# Java - MongoDb Query
## Exercise with mongoDB & Java

### run dockerized server 
`docker run --name mongodb -d -p 27017:27017 mongo:4.1.5`

### check IP andress of the server 
`docker network inspect bridge` (suppose 172.17.0.2)

### run dockerized client 
`docker run -it --name mongodb-client -v $HOME:/home/developer mongo:4.1.5 /bin/bash`

### Inside the container, start the client
`mongo 172.17.0.2`
 
### Populate DB
`mongo 172.17.0.2 < populate`

### Start MongoDemo.java and enjoy!
 
