
FROM ubuntu:19.10

RUN apt-get update

RUN useradd -d /home/rick/ -m -p rick -s /bin/rbash rick
RUN echo "rick:rick" | chpasswd

WORKDIR /home/rick

COPY flag .
COPY ynetd .
COPY teleporter2 .

RUN chmod +x ynetd teleporter2

RUN chown -R root:root /home/rick

USER ctf
CMD ./ynetd -p 13337 ./teleporter2
