#!/bin/sh

echo "wordpress script start"

if [ -f ./wp-config.php ]
then
	echo "wordpress already downloaded"
else

	wget http://wordpress.org/latest.tar.gz
	tar xfz latest.tar.gz
	mv wordpress/* .
	rm -rf latest.tar.gz
	rm -rf wordpress
fi

echo "wordpress script end"

exec "$@"