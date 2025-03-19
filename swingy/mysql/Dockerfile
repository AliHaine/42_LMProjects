FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=pass
ENV MYSQL_DATABASE=data

COPY ./mysql/init.sql /docker-entrypoint-initdb.d/
COPY ./mysql/conf.cnf /etc/mysql/conf.d/

EXPOSE 3306