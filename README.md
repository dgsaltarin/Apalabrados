# Apalabrados

Apalabrados is a service to store and classify string inputs into text, number or character.
## Requirements

For building and running the application you need:

- [JDK 11.0.11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html)
- [Spring Boot 2.4.4](https://spring.io/projects/spring-boot)
- [Gradle](https://gradle.org/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.dgsaltarin.apalabrados.ApalabradosApplication` class from your IDE.

Alternatively you can use gradle to build a jar file and then run it using the command line inside the project folder:
```shell
java -jar build/libs/Apalabrados-0.0.1-SNAPSHOT.jar
```

## Deploy on Heroku

This application is deployed on heroku and can be access at: [Apalabrados](https://apalabradosplatzi.herokuapp.com)

## How to use it
To use this application you need to use a post request and point to /input, and inside the body send a request like this.
```
{
    "input": "130"
}
```
![alt text](https://res.cloudinary.com/dgmanga/image/upload/v1634654014/Diagrama_de_flujo.png)
