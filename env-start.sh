#!/bin/sh

pattern="--"

if [ $# -eq 0 ]
then
    echo "Calling to full docker compose services..."
    docker_compose
elif [ $# -ne 0 ]
then
    if echo "$1" | grep -q $pattern
    then
        check_task "$@"
    fi
else
    echo "Calling to specified docker compose service..."
    docker_compose_service "$@"
fi

check_task()
{
    if echo "$1" | grep -q "clean"
    then
        cleanup
    elif echo "$1" | grep -q "deploy"
    then 
        deploy
    elif echo "$1" | grep -q "help"
    then 
        help
    else
        echo "Unknown flag {$1}" 
        exit 1
    fi
}

cleanup() 
{
    echo "docker rm stg-liferay-1"
} 

deploy()
{
    cd /modules || exit
    echo "blade gw clean deploy"
    cd ../
    cd /themes || exit
    echo "blade gw clean deploy"
    cd ../
}

docker_compose() 
{
    echo "docker compose -p stg up --build"
}

docker_compose_service()
{
    echo "docker compose -p stg up --build ${1}"
}

help() 
{
    echo " *** See the commands availables bellow: *** "
    echo 
    echo "1 - help [Explains usage and commands availables]"
    echo "2 - deploy [To deploying the modules and themes before to be started]"
    echo "3 - clean [To cleaning the container before to be started]"
    echo
    echo "In addition, you can use to call specific services, adding the service name as a parameter"

    exit 1
}
