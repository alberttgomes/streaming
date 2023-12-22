#!bin/bash

if [ $# -eq 0 ]
then
    echo "Calling to full docker compose services..."
    docker_compose
else
    echo "Calling to specified docker compose service..."
    service = $1
    docker_compose_service
fi

docker_compose() 
{
    echo "docker compose -p stg up --build"
}

docker_compose_service()
{
    echo "docker compose -p stg up --build ${service}"
}