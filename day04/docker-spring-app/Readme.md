## Details App

## create application using spring initializer

## write business logic

### Build application

    mvn clean install

### Run Application
    mvn spring-boot:run

### Create docker image

    mvn install dockerfile:build

## Run docker image

    docker run -p 8081:8080 mayank125/docker-spring-app:1.0.0