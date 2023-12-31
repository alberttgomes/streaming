#!/bin/bash

FLAG_PATTERN="clean\|cleanAll\|copy\|deploy\|deployToDocker\|down\|help\|up"
INITIALIZE="$(date +'%Y-%m-%d') DXP initializing..."
PATH_RELATIVE="/dev/projects/hotel/MePortlet/streaming"
PROJECT_NAME="stg"
SERVICES_PATTERN="database\|liferay"

function check_task() {
    handle_flag "$1" "$2"
}

function check_services_task() {
    handle_service_flag "$1"
}

function cleanAll() {
    docker rm "${PROJECT_NAME}-database-1" -f
    docker rm "${PROJECT_NAME}-liferay-1" -f
}
 
function cleanUp() {
    docker rm "${PROJECT_NAME}-liferay-1" -f

    echo "$(date +'%Y-%m-%d') Cleaned."

    echo "$INITIALIZE"

    docker compose -p "$PROJECT_NAME" up --build
} 

function copy() {
    cd ~/"${PATH_RELATIVE}/bundles/osgi/modules/"  || exit
    docker cp . "${PROJECT_NAME}-liferay-1:/opt/liferay/osgi/modules";
    cd - || exit
    
    cd ~/"${PATH_RELATIVE}/themes/streaming-theme/dist/" || exit
    docker cp . "${PROJECT_NAME}-liferay-1:/mnt/liferay/deploy"
    cd - || exit
}

function database() {
    echo "Getting database docker compose service.."

    docker compose -p "$PROJECT_NAME" up --build "$1"
}

function deploy() {   
    cd ~/"$PATH_RELATIVE"/modules || exit
    blade gw clean deploy
    cd ../
    cd ~/"$PATH_RELATIVE"/themes || exit
    blade gw clean deploy
    cd ../

    echo "$(date +'%Y-%m-%d') Deployed."

    echo "$INITIALIZE"

    docker compose -p "$PROJECT_NAME" up --build
}

function deployToDocker() {
    if [ "$1" ]
    then
        cd ~/"$PATH_RELATIVE"/modules/"$1" || return

        blade gw clean deploy
        
        exit 1

    elif [ "$1" ] && [ "$2" ]
    then
        cd ~/"$PATH_RELATIVE"/modules/"$1"/"$2" || return

        blade gw clean deploy

        exit 1

    else
        cd ~/"$PATH_RELATIVE"/modules/ || return

        blade gw clean deploy

        exit 1

    fi
}

function docker_compose() {
    docker compose -p "$PROJECT_NAME" up --build
}

function down() {
    if [ "$2" ]
    then
        if echo "$2" | grep -q "\\-\|f"
        then
            echo "Stopping services force..."
            
            docker stop "${PROJECT_NAME}-database-1 \\-\|f"

            docker stop "${PROJECT_NAME}-liferay-1 \\-\|f"

            exit 1
        else
            echo "Unknown flag: $2"

            exit 1
        fi
    else
        echo "Stopping services.."

        docker stop "${PROJECT_NAME}-database-1"

        docker stop "${PROJECT_NAME}-liferay-1"

        exit 1
    fi
}

function handle_flag() {
    case "$1" in
        "clean")
            cleanUp ;;
        "cleanAll")
            cleanAll ;;
        "copy")
            copy ;;
        "deploy")
            deploy ;;
        "deployToDocker")
            deployToDocker "$@" "$@" ;;    
        "down")
            down "$@" "$@" ;;
        "help")
            help ;;
        "up" )
            up ;;
        *)
    esac
}

function handle_service_flag() {
    case "$1" in
        "database")
            database "$@" ;;
        "liferay")
            liferay "$@" ;;    
        *)
    esac
}

function help() {
    cat <<EOF
(*** SEE THE COMMANDS AVAILABLES BELLOW: ***) 

1. - help [Explains usage and available commands]

2. - clean [Cleans the container before started]
3. - cleanAll [Clean all containers before started]
4. - copy [Copy packages $(.jar) and, $(.war) built, to modules and themes to into the container]
5. - deploy [Deploys modules and themes before started]
6. - down [Stop all container. Can be used using the \\-\|f flag to force]
7. - up [To up the containers wihtout build again]

How to use theses commands, for example: 
\"./env.start.sh deploy\"

In addion, you can call specific services by adding the service name as a parameter.   

There's now, it's available the follow services:
    1. database [Get database service docker environment]
    2. liferay [Get liferay service docker environment]
EOF
    exit 1
}

function liferay() {
    echo "Getting DXP docker compose service.."

    docker compose -p "$PROJECT_NAME" up --build liferay
}

function up() {
    "${INITIALIZE}"

    docker compose -p "$PROJECT_NAME" up
}

if [ $# -eq 0 ]
then
    docker_compose
else
    if echo "$1" | grep -q "$FLAG_PATTERN"
    then
        check_task "$@"

        exit 1

    elif echo "$1" | grep -q "$SERVICES_PATTERN"
    then
        check_services_task "$@"

        exit 1
        
    else
        echo "Unknown flag: $1"
       
        exit 1 
    fi
fi

