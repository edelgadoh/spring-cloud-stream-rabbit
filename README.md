# spring-cloud-stream-rabbit
POC to validate event-driven microservices using Spring Cloud Stream with Rabbit binder.

## Build + Tests
To build locally and to validate all requirements automatically, run the Unit tests and Functional Tests with:
```
./gradlew clean build
```

## Docker-compose
The Dockerfile is instructed to build the application, create the fat jar and 
let it ready to be used as an image.

To start the all the microservices in one shot, just execute:
```
docker-compose up -d
```

 
If there is a need to rebuild all the microservices, just include --build in the command:
```
docker-compose up --build
```

To stop all the microservices, execute:
```
docker-compose down
```

## Notes:
All the project was tested on:

- docker version 20.10.13
- docker-compose version 1.29.2
- openjdk 11.0.13 2021-10-19
