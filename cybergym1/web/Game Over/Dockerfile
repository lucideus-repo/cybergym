# Origin image
FROM debian

RUN apt-get update
RUN apt-get install -y apache2

# Setup the vulnerability environment
COPY bg.jpg  /var/www/html/
COPY index.html /var/www/html/

# Entry point
ENTRYPOINT service apache2 start && /bin/bash
