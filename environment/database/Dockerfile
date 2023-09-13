FROM mysql:latest


# COPY --chown=mysql:mysql /dump/ ./var/mysql/backup
# COPY --chown=mysql:mysql /scripts ./docker-entrypoint

ENV MYSQL_ROOT_PASSWORD=test

EXPOSE 3306 3307

# ENTRYPOINT [ "./docker-entrypoint/scripts/setup_database.sh" ]