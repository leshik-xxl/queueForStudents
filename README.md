# Virtual queue for students back-end

### Operations: 
 - login
    - POST http://localhost:8080/login
    - will return username
 - logout
    - POST http://localhost:8080/logout
    - will return username
 - get queue
    - GET http://localhost:8080/queue
    - will return list of queue
 - take/leave the queue
    - GET http://localhost:8080/action
 

#### build jar
`mvn clean package`

#### run jar
`java -jar queueForStudents-0.0.1-SNAPSHOT.jar`

