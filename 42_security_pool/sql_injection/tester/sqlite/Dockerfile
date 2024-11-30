FROM php:8.2-apache

RUN apt-get update && apt-get install -y \
    sqlite3 libsqlite3-dev \
    && docker-php-ext-install pdo pdo_sqlite \
    && apt-get clean

ENV SQLITE_DB_PATH="/var/www/html/data/testdb.sqlite"
RUN mkdir -p /var/www/html/data && chmod 777 /var/www/html/data

COPY ./tester/sqlite/mysqltester.php /var/www/html/
COPY ./tester/sqlite/mysqlget.php /var/www/html/
COPY ./tester/sqlite/index.html /var/www/html/
COPY ./tester/sqlite/init.sql /docker-entrypoint-initdb.d/

WORKDIR /var/www/html/

CMD ["/bin/sh", "-c", "set -e; echo 'Initializing SQLite database...'; if [ ! -f $SQLITE_DB_PATH ]; then sqlite3 $SQLITE_DB_PATH < /docker-entrypoint-initdb.d/init.sql; fi && chmod 777 /var/www/html/data/testdb.sqlite && apache2-foreground"]

EXPOSE 80