#!/bin/bash

echo "Script starting..."

mysqld &

until mysqladmin ping -h"$MYSQL_HOSTNAME" -u"$MYSQL_USER" -p"$MYSQL_PASSWORD" --silent; do
    echo "Waiting for MySQL to be ready..."
    sleep 1
done

echo "MySQL is ready, proceeding with setup..."

echo "CREATE DATABASE IF NOT EXISTS wordpress ;" | mysql -h"$MYSQL_HOSTNAME" -u"$MYSQL_USER" -p"$MYSQL_PASSWORD"
echo "CREATE USER IF NOT EXISTS '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD' ;" | mysql -h"$MYSQL_HOSTNAME" -u"$MYSQL_USER" -p"$MYSQL_PASSWORD"
echo "GRANT ALL PRIVILEGES ON wordpress.* TO '$MYSQL_USER'@'%' ;" | mysql -h"$MYSQL_HOSTNAME" -u"$MYSQL_USER" -p"$MYSQL_PASSWORD"
echo "ALTER USER 'root'@'localhost' IDENTIFIED BY '12345' ;" | mysql -h"$MYSQL_HOSTNAME" -u"$MYSQL_USER" -p"$MYSQL_PASSWORD"
echo "FLUSH PRIVILEGES;" | mysql -h"$MYSQL_HOSTNAME" -u"$MYSQL_USER" -p"$MYSQL_PASSWORD"

echo "MySQL setup end."