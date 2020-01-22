# Livescore Project

Contact Email: mfava85@gmail.com

## Tech Stack

- Java 11
- Spring Boot
- Feign Client
- Lombok
- Swagger

## Description

Project is a single module which retrieves Feeds from an endpoint via Feign Client.
Results are cached (1 minute ttl) to avoid repeated hits for same info.
A single API is provided to get events and filters for status and liveStatus are supported. 

## Documentation

Swagger documentation providerd @ below url.

http://localhost:8080/swagger-ui.html 

## Execution

Prerequisite Maven 3.6.1 or above

In project folder exectue 'mvn spring-boot:run'

Api will be available @ http://localhost:8080

