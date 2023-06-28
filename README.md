# Coffee Finder Mysql MVC

## Introduction

Coffee-finder-mysql-mvc is an app based on Spring MVC, a highly scalable event-driven microservice that consumes 
messages from the message-broker software **RabbitMQ** (which is used as a binder with the possibility to switch to 
**Apache Kafka**) via Spring Cloud Stream, saves received coffees into DB (MySQL) and shows available coffees to the end 
users via server-side Java template engine **Thymeleaf**. 

The app uses WebSocket, persistent, bi-directional, full duplex TCP connection from a user's web browser to a server, 
to avoid "request - response" scenario that allows to initiate transmission of data to the requesting side regardless 
HTTP requests to keep the list of available coffees consistent.

## Technologies

- Java 11
- MySQL
- Spring Boot
- Spring Data
- Spring MVC
- Thymeleaf
- Domain-Driven Design
- Spring Cloud Stream
- RabbitMQ
- WebSocket