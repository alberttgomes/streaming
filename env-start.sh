#!/bin/bash

PROJECT_NAME="stg"
SERVICES_PATTERN="database\|liferay"
STARTING="$(date +'%Y-%m-%d') Starting Portal ..."
TAG_PATTERN="clean\|deploy\|help"

function check_task() {
    handle_flag "$1"
}

function check_services_task() {
    echo "Getting docker compose service ${1} ..." 

    handle_service_flag "$1"
}
 
function cleanup() {
    docker rm stg-liferay-1 -f

    echo "$(date +'%Y-%m-%d') Cleaned."

    echo "$STARTING"

    docker compose -p "$PROJECT_NAME" up --build
} 

function deploy() {   
    relativePath="/dev/projects/hotel/MePortlet/streaming"

    cd ~/"$relativePath"/modules || exit
    blade gw clean deploy
    cd ../
    cd ~/"$relativePath"/themes || exit
    blade gw clean deploy
    cd ../

    echo "$(date +'%Y-%m-%d') Deployed."

    echo "$STARTING"

    docker compose -p "$PROJECT_NAME" up --build
}

function docker_compose() {
    docker compose -p "$PROJECT_NAME" up --build
}

function docker_compose_service() {
   docker compose -p "$PROJECT_NAME" up --build "${1}"
}

function handle_flag() {
    case "$1" in
        "clean")
            cleanup ;;
        "deploy")
            deploy ;;
        "help")
            help ;;
        "liferay")
            liferay ;;    
        *)
    esac
}

function handle_service_flag() {
    case "$1" in
        "database")
            cleanup ;;
        "liferay")
            liferay ;;    
        *)
    esac
}

function help() {
    cat <<EOF
 *** See the available commands below: *** 

1. - help [Explains usage and available commands]
2. - deploy [Deploys modules and themes before starting]
3. - clean [Cleans the container before starting]

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
    docker compose -p "$PROJECT_NAME" up --build liferay
}

if [ $# -eq 0 ]
then
    echo "Getting docker compose full services ..."
    docker_compose
else
    if echo "$1" | grep -q "$TAG_PATTERN"
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
