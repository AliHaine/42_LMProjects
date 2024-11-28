FROM mysql:9.1.0

VOLUME ["/var/lib/mysql"]

ENV MYSQL_ROOT_PASSWORD="root" \
    MYSQL_DATABASE="testdb"

COPY data.sql /docker-entrypoint-initdb.d/

EXPOSE 8181

CMD ["mysqld"]