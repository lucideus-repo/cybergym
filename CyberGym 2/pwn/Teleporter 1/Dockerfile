
FROM debian

RUN apt-get update

RUN useradd -d /home/rick/ -m -p rick -s /bin/rbash rick
RUN echo "rick:rick" | chpasswd

WORKDIR /home/rick

COPY teleporter .
COPY flag .
COPY ynetd .

RUN chown -R root:root /home/rick

USER rick
CMD ./ynetd -p 1234 ./teleporter
