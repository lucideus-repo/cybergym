# Fix It

Create a docker image with
``` bash
docker build -t fixit .
```

Start the docker container with
``` bash
docker run -d -p 80:4444 --name  fixit--rm -it fixit
```

Solution 

The participants need to fix the corrupted image and then extract the hidden flag in the image
