FROM php:8.2-apache

COPY ./mysqltester.php /var/www/html/
COPY ./index.html /var/www/html/

RUN docker-php-ext-install mysqli


WORKDIR /var/www/html/

CMD ["apache2-foreground"]