#!/bin/sh

echo "wordpress script start"



wget http://wordpress.org/latest.tar.gz
tar xfz latest.tar.gz
mv wordpress/* .
rm -rf latest.tar.gz
rm -rf wordpress


echo "wordpress script end"

exec "$@"