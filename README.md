# MeFit

Mefit is an app that helps you with your daily exercise. In this repository you will find the api that brings you the programs, workouts and of course the exercises.
For more information: <a href="https://github.com/NotFotis/MeFit/wiki/API-Documentation">API Documentation</a>

## Technologies Used
Spring Boot 2.5.4
Gradle 7.3.3
PostgreSQL 13
Java 11
Spring Security
OAuth2 with Keycloak
## Prerequisites
Java 11 or higher
Gradle 7.3.3 or higher
PostgreSQL 13 or higher
Keycloak server running on http://localhost:8080/auth
## Getting Started
Clone the repository:
git clone https://github.com/NotFotis/MeFit.git
Navigate to the project directory:
cd MeFit
Build the application:
./gradlew build
Run the application:
./gradlew bootRun
Test the application by sending requests to http://localhost:8080.
Features
This application provides the following REST API endpoints:

/users: CRUD operations for managing users <br />
/profile: CRUD operations for managing profiles <br />
/goal: CRUD operations for managing goals <br />
/program: CRUD operations for managing programs <br />
/workout: CRUD operations for managing workouts <br />
/exercise: CRUD operations for managing exercises <br />
It also implements Spring Security and OAuth2 with Keycloak for authentication and authorization.

The application follows a standard Spring Boot structure, with the following packages:

com.example.application: main package
com.example.application.config: configuration classes for Spring Boot, the database, and Spring Security
com.example.application.controllers: REST API controllers
com.example.application.mappers: mapper classes for mapping between DTOs and entities
com.example.application.models: entity classes
com.example.application.repositories: Spring Data JPA repositories for accessing the database
com.example.application.services: service classes for business logic

## Contributing
Fotis Staikos
Konstantinos Kokonos

Acknowledgements
Spring Boot
Gradle
PostgreSQL
Spring Security
OAuth2 with Keycloak
