FROM mysql:9.1.0

ENV MYSQL_ROOT_PASSWORD="root" \
    MYSQL_DATABASE="testdb"

COPY init.sql /docker-entrypoint-initdb.d/


EXPOSE 8181

CMD ["mysqld"]