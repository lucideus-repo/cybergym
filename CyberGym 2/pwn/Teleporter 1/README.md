# Teleporter

## Binary Exploitation

Challenge is to analyse the given binary and find way to exploit it. Use the same exploit to get flag from the remote server.

### Install instructions

Build the binary with

```bash
gcc teleporter.c -o teleporter -no-pie -fno-stack-protector
```

Create a docker image with

```bash
docker build -t teleporter .
```

Start the docker container with

```bash
docker run -d -p 1234:1234 --name  teleporter--rm -it teleporter
```

Solution is written on python 3
