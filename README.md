# MeFit

Mefit is an app that helps you with your daily exercise. In this repository you will find the api that brings you the programs, workouts and of course the exercises.
For more information: <a href="https://github.com/NotFotis/MeFit/wiki/API-Documentation">API Documentation</a> <br />
App is deployed with railway at: https://mefit-production.up.railway.app/api/v1/ (Add endpoint after /) <br />
App's frontend is at https://github.com/ZiogasThlem/my-fit

## Technologies Used <br />
Spring Boot 2.5.4 <br />
Gradle 7.3.3 <br />
PostgreSQL 13 <br />
Java 11 <br />
Spring Security <br />
OAuth2 with Keycloak <br />
## Prerequisites <br />
Java 11 or higher <br />
Gradle 7.3.3 or higher <br />
PostgreSQL 13 or higher <br />
Keycloak server running on http://localhost:8080/auth <br />
## Getting Started <br />
Clone the repository: <br />
git clone https://github.com/NotFotis/MeFit.git <br />
Navigate to the project directory: <br />
cd MeFit <br />
Build the application: <br />
./gradlew build <br />
Run the application: <br />
./gradlew bootRun <br />
Test the application by sending requests to http://localhost:8080. <br />
Features <br />
This application provides the following REST API endpoints: <br />

/users: CRUD operations for managing users <br />
/profile: CRUD operations for managing profiles <br />
/goal: CRUD operations for managing goals <br />
/program: CRUD operations for managing programs <br />
/workout: CRUD operations for managing workouts <br />
/exercise: CRUD operations for managing exercises <br />
It also implements Spring Security and OAuth2 with Keycloak for authentication and authorization. <br />

The application follows a standard Spring Boot structure, with the following packages: <br />

com.example.application: main package <br />
com.example.application.config: configuration classes for Spring Boot, the database, and Spring Security <br />
com.example.application.controllers: REST API controllers <br />
com.example.application.mappers: mapper classes for mapping between DTOs and entities <br />
com.example.application.models: entity classes <br />
com.example.application.repositories: Spring Data JPA repositories for accessing the database <br />
com.example.application.services: service classes for business logic <br />

## Contributing  <br />
Fotis Staikos <br />
Konstantinos Kokonos <br />
Tilemachos Ziogas <br />
Tasos Antoniou <br />

Acknowledgements <br />
Spring Boot <br />
Gradle <br />
PostgreSQL <br />
Spring Security <br />
OAuth2 with Keycloak <br />
