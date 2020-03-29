# JavaMongoDbQuery

Esercizio con mongoDB & Java

Lanciare il server dockerizzato 
• docker run --name mongodb -d -p 27017:27017 mongo:4.1.5

Veriﬁcare l’indirizzo IP del server 
• docker network inspect bridge (Supponiamo sia 172.17.0.2)

Lanciare il client dockerizzato 
• docker run -it --name mongodb-client -v $HOME:/home/developer mongo:4.1.5 /bin/bash

Dentro il container, lanciare il client 
• mongo 172.17.0.2
 
Popolare dei dati 
• mongo 172.17.0.2 < populate 

Lanciare MongoDemo.java
 
