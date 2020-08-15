# Theft

Create a docker image with
``` bash
docker build -t theft .
```

Start the docker container with
``` bash
docker run -d -p 1111:1111 --name  theft--rm -it theft
```

Solution 

The participants need to bypass the restrictions and perform a SSRF and get the flag.
