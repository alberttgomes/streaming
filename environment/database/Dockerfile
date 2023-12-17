FROM mysql:8.0

COPY --chown=mysql:mysql /environment/database/dump/ /
COPY --chown=mysql:mysql /environment/database/scripts/setup_database.sh /docker-entrypoint-initdb.d/

ENV MYSQL_ROOT_PASSWORD=test

EXPOSE 3306 3307