#!/bin/sh

echo "Starting mariadb script"

/etc/init.d/mariadb start

#Check if the database exists

if [ -d "/var/lib/mysql/$MYSQL_DATABASE" ]
then

	echo "Database already exists"
	/etc/init.d/mariadb stop
else

# Set root option so that connexion without root password is not possible

mysql_secure_installation << _EOF_

Y
Y
root4life
root4life
Y
n
Y
Y
_EOF_

echo "Grant all and creating database if not exit"
echo $MYSQL_DATABASE
echo $MYSQL_USER

#Add a root user on 127.0.0.1 to allow remote connexion
#Flush privileges allow to your sql tables to be updated automatically when you modify it
#mysql -uroot launch mysql command line client
echo "GRANT ALL ON *.* TO 'root'@'%' IDENTIFIED BY '$MYSQL_ROOT_PASSWORD'; FLUSH PRIVILEGES;" | mysql -uroot

#Create database and user in the database for wordpress

echo "CREATE DATABASE IF NOT EXISTS $MYSQL_DATABASE; GRANT ALL ON $MYSQL_DATABASE.* TO '$MYSQL_USER'@'%' IDENTIFIED BY '$MYSQL_PASSWORD'; FLUSH PRIVILEGES;" | mysql -u root

echo "No error occured."

#echo "Import databse from wordpress.sql"

#Import database in the mysql command line
mysql -uroot -p$MYSQL_ROOT_PASSWORD $MYSQL_DATABASE < /usr/local/bin/wordpress_data.sql

/etc/init.d/mariadb stop

fi

exec "$@"