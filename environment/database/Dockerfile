FROM mysql:latest

COPY --chown=mysql:root ./dump/ ./var/mysql/backup
COPY --chown=mysql:root ./scripts/setup_database.sh ./docker-entrypoint/setup_database.sh

ENV MYSQL_ROOT_PASSWORD=test

EXPOSE 3306 3307