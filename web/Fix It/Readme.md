# Fix It

Create a docker image with
``` bash
docker build -t fixit .
```

Start the docker container with
``` bash
docker run -d -p 1234:1234 --name  fixit--rm -it teleporter
```

Solution 

The participants need to fix the corrupted image and then extract the hidden flag in the image
