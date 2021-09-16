# sudo docker build -t theft .
# sudo docker run -d -p 1234:80 --rm --name theft -it theft

FROM ubuntu:16.04

RUN apt-get update

RUN apt-get install -y \
    apache2 php \
    php-curl \
    libapache2-mod-php

RUN rm /var/www/html/index.html
COPY index.php /var/www/html/
COPY php.ini /etc/php/7.0/apache2/
COPY flag /flag

# Entry point
ENTRYPOINT service apache2 start && /bin/bash
