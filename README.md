## Project Vertex Backend

This is a backend project developed in Spring Boot that provides authentication services, user management, and event creation associated with registered users. Below are the key aspects of the project and instructions on how to set up and run it.

### Project Description

Vertex Backend project offers functionalities for user authentication, registration, event management, and user profile. It utilizes Spring Security for JWT-based authentication and Spring Data JPA for data persistence.

### Technologies Used

-   **Spring Boot**: Java application framework for creating stand-alone, production-grade Spring-based applications.
-   **Spring Security**: Provides security at both method and HTTP level.
-   **Spring Data JPA**: Facilitates access to relational databases from Spring applications.
-   **JWT (JSON Web Token)**: Used for token-based authentication.
-   **Lombok**: Reduces Java boilerplate code with annotations.
-   **MySQL**: Relational database used for data storage in production.
-   **Google Cloud**: Cloud platform used to host the MySQL database.
-   **Render**: Platform used for deploying and hosting the backend application.

### Project Structure

The project is structured into several packages:

-   **`auth`**: Contains controllers, services, and models related to user authentication and registration.
-   **`config`**: Spring configurations including security settings (`SecurityConfig`) and application configuration (`ApplicationConfig`).
-   **`event`**: Models and entities related to events that can be created by users.
-   **`jwt`**: Implementation of JWT service for token generation and validation.
-   **`user`**: Controller and service for user management.

### Setup and Execution

1.  **Prerequisites**:
    
    -   Java JDK 11 or higher.
    -   IDE compatible with Spring Boot (e.g., IntelliJ IDEA, Eclipse).
    -   Maven for dependency management.
2.  **Clone the Repository**:
    
    bash
    
    Copy code
    
    `git clone <REPOSITORY_URL>` 
    
3.  **Import and Configure in IDE**: Import the project into your IDE as an existing Maven project.
    
4.  **Database Configuration**:
    
    -   Set up a MySQL database on Google Cloud.
    -   Update the `application.properties` file with database credentials and connection URL for MySQL on Google Cloud.
5.  **Build and Run**: Run the Spring Boot application from your IDE.
    
6.  **Deployment on Render**:
    
    -   Deploy the application on Render for hosting and production deployment.
    -   Configure Render to handle HTTP and HTTPS requests to your backend application.

### Available Endpoints

-   **Authentication**:
    -   `POST /auth/login`: Endpoint to log in and obtain a JWT token.
    -   `POST /auth/register`: Endpoint to register a new user.
-   **User Management**:
    -   `GET /user`: Retrieves all users.
    -   `GET /user/{userId}`: Retrieves a user by ID.
    -   `POST /user/{userId}/events`: Creates an event associated with an existing user.
    -   `PUT /user/{userId}`: Updates user information.

### Additional Notes

-   Ensure the `application.properties` file is configured correctly, especially the properties related to MySQL database connection on Google Cloud.
-   Security configurations are centralized in `SecurityConfig` and `JwtAuthenticationFilter`, ensuring that authentication routes are protected by JWT.
-   Use Render for deploying and hosting the backend application, ensuring environment variables and security settings are properly configured for production environments.

This README provides an overview of the project and basic setup instructions for running it in development and production environments using Spring Boot, MySQL on Google Cloud, and Render as the deployment platform. Adjust and expand as per specific project requirements and deployment environment.
