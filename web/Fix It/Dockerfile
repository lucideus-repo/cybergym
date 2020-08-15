# Origin image
FROM debian

# update
RUN apt update

# Setup Server Environment
RUN apt install -y apache2

# Setup the vulnerability environment
RUN rm /var/www/html/index.html
COPY files /var/www/html/

# Entry point
ENTRYPOINT service apache2 start
