# Teleporter 2


Build the binary with

```bash
gcc pwn2.c -o pwn2 -fno-stack-protector
```

Create a docker image with
```
docker build -t teleporter2 .
```

Start the docker container with
```
docker run -d -p 13337:13337 --rm --name teleporter2 -it teleporter2
```

Solution is written on python 3
