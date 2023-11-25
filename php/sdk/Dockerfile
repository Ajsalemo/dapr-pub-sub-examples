FROM php:8.1-apache-bullseye as build
WORKDIR /app/
COPY . .
# We need to manually download composer since the composer image itself references the latest PHP version (8.2.12 at the time of writing this)
# This causes dependency issues when trying to install the Dapr SDK plus its dependencies
RUN php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');" && \
    php -r "if (hash_file('sha384', 'composer-setup.php') === 'e21205b207c3ff031906575712edab6f13eb0b361f2085f1f1237b7126d785e826a450292b6cfd1d64d92e6563bbde02') { echo 'Installer verified'; } else { echo 'Installer corrupt'; unlink('composer-setup.php'); } echo PHP_EOL;" && \
    php composer-setup.php && \
    php -r "unlink('composer-setup.php');" && \
    apt-get update -yy && \
    apt-get install -yy git && \
    php composer.phar install --prefer-dist --no-dev --optimize-autoloader --no-interaction

FROM php:8.1-apache-bullseye as production
WORKDIR /var/www/html
COPY --from=build /app/ ./
COPY --from=build /app/apache/000-default.conf /etc/apache2/sites-available/

# Change permissions to read/write for storage or else it'll fail to write out logs due to lack of permissions
# Change ownership to www-data for Apache
RUN chmod 777 -R /var/www/html/storage/ && \
    chown -R www-data:www-data /var/www/ && \
    a2enmod rewrite && \
    service apache2 restart

EXPOSE 80