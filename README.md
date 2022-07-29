# spring-cloud-stream-rabbit
Sample project with three event-driven microservices using Spring Cloud Stream & RabbitMQ binder 
(by using Spring Cloud Stream, it can be changed to Kafka without any effort).

![Architecture](diagram.png?raw=true)

## Build + Tests
To build locally:
```
./gradlew clean build
```

## Docker-compose
There is a Dockerfile for each microservice to instruct to build the application, create the fat jar and 
let it ready to be used as an image.

The docker-compose starts the RabbitMQ broker and the three microservices.

To start the broker and all the microservices in one shot, just execute:
```
docker-compose up -d
```

To rebuild all the microservices, just include --build in the command:
```
docker-compose up --build
```

To stop all the microservices, execute:
```
docker-compose down
```

To see the logs, execute:
```
docker-compose logs -f
```

## Notes:
All the project was tested on:

- docker version 20.10.13
- docker-compose version 1.29.2
- openjdk 11.0.13 2021-10-19

## External links:
- https://github.com/spring-cloud/spring-cloud-stream/blob/main/docs/src/main/asciidoc/spring-cloud-stream.adoc#spring-cloud-stream-overview-application-model
- https://cloud.spring.io/spring-cloud-static/spring-cloud-stream-binder-rabbit/2.1.1.RELEASE/multi/multi__configuration_options.html
- https://cloud.spring.io/spring-cloud-static/Greenwich.RELEASE/multi/multi__rabbitmq_binder.html