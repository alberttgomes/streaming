#!/bin/sh

pattern="(clean|deploy|help)"
project_name="stg"
starting="$(date +'%Y-%m-%d') Starting Portal ..."

check_task()
{
    handle_flag "$1"
}

cleanup() 
{
    docker rm stg-liferay-1

    echo "$(date +'%Y-%m-%d') Cleaned."

    echo "$starting"

    docker compose -p "$project_name" up --build
} 

deploy()
{   
    relativePath="/dev/projects/hotel/MePortlet/streaming"

    cd ~/"$relativePath"/modules || exit
    blade gw clean deploy
    cd ../
    cd ~/"$relativePath"/themes || exit
    blade gw clean deploy
    cd ../

    echo "$(date +'%Y-%m-%d') Deployed."

    echo "$starting"

    docker compose -p "$project_name" up --build
}

docker_compose()
{
    docker compose -p "$project_name" up --build
}

docker_compose_service()
{
   docker compose -p "$project_name" up --build "${1}"
}

handle_flag() {
    case "$1" in
        "clean")
            cleanup ;;
        "deploy")
            deploy ;;
        "help")
            help ;;
        *)
            echo "Unknown flag: $1"
            exit 1 ;;
    esac
}

help() 
{
    cat <<EOF
 *** See the available commands below: *** 

1. - help [Explains usage and available commands]
2. - deploy [Deploys modules and themes before starting]
3. - clean [Cleans the container before starting]

How to use theses commands, for example: 
\"./env.start.sh deploy\"

In addion, you can call specific services by adding the service name as a parameter.
EOF
    exit 1
}

if [ $# -eq 0 ]
then
    echo "Calling to full docker compose services..."
    docker_compose
elif [ $# -ne 0 ]
then
    if echo "$1" | grep -q "$pattern"
    then
        check_task "$@"
    fi
else
    echo "Calling to specified docker compose service..."
    docker_compose_service "$@"
fi
