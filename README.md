# Containerized Microservices Data Collection and Analytics System

> ⚠️ **Important:** This README provides a high-level overview of the project. For comprehensive details, including architecture, design decisions, and implementation, please refer to the [Project Documentation (PDF)](./Data%20Analytics%20System%20Documentation.pdf).

This project implements a containerized microservices system for data collection and analytics using Docker. The system is built with Docker containers and leverages microservices architecture to provide modular and efficient functionality.

## System Architecture

The system comprises the following services:
1. **Enter Data Service**: Collects and stores data (e.g., temperatures, grades) into a MySQL database after validating user credentials through the Authentication Service.
2. **Authentication Service**: Validates user credentials for secure access.
3. **Analytics Service**: Retrieves data from the MySQL database, calculates statistics (Min, Max, Avg), and stores the results in MongoDB.
4. **Show Results Service**: Fetches and displays statistical results from MongoDB to authenticated users.
5. **MySQL Database Service**: Stores user-submitted data.
6. **MongoDB Database Service**: Stores computed statistics.

These microservices interact using dedicated networks for security and isolation:
- `mysql-network`: Links services to MySQL.
- `mongo-network`: Links services to MongoDB.
- `services-network`: Handles communication between core services.

![image](https://github.com/user-attachments/assets/a13d66a6-ef93-4919-9cca-80cd7f3664d2)

## Features

- **Containerization**: Each service is containerized using a custom `Dockerfile`.
- **Orchestration**: Managed via `docker-compose.yml` to ensure seamless integration.
- **Authentication**: Secure user validation for accessing services.
- **Data Analytics**: Real-time computation of statistics (e.g., Min, Max, Avg).

## Technology Stack

- **Docker**: Used for containerization and orchestration.
- **Spring Framework**: Backend services implemented using Spring MVC and REST.
- **MySQL**: Relational database for raw data storage.
- **MongoDB**: NoSQL database for storing analytics results.
- **JPA/Hibernate**: ORM tools for database interactions.

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/EthicalYuu/containerized-data-analytics-system.git
   cd containerized-data-analytics-system

2.  Build and start the services using Docker Compose:

    ```bash
    docker-compose up --build

2.  Access the services:

    -   **Enter Data Service**: http://localhost:8080
    -   **Authentication Service**: http://localhost:8081
    -   **Show Results Service**: http://localhost:8084

Docker Configuration
--------------------

### Sample `Dockerfile` (for each service)

```
FROM openjdk:20
COPY ./target/springservice-0.0.1.SNAPSHOT.jar springservice-0.0.1.SNAPSHOT.jar
CMD ["java", "-jar", "springservice-0.0.1.SNAPSHOT.jar"]
```

### `docker-compose.yml`

```
version: "3.8"

services:
  enter-data-service:
    image: enter-data-service
    ports:
      - "8080:8080"
    networks:
      - mysql-network
      - services-network
    depends_on:
      - mysqldb
      - authentication-service

  authentication-service:
    image: authentication-service
    ports:
      - "8081:8081"
    networks:
      - services-network

  analytics-service:
    image: analytics-service
    ports:
      - "8083:8083"
    networks:
      - mysql-network
      - mongo-network

  show-results-service:
    image: show-results-service
    ports:
      - "8084:8084"
    networks:
      - mongo-network
      - services-network
    depends_on:
      - mongodb

  mysqldb:
    image: mysql:8
    networks:
      - mysql-network
    ports:
      - "3307:3306"
    volumes:
      - ./init.sql:/docker-entrypoint-initdb.d/init.sql
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: temperature

  mongodb:
    image: mongo
    networks:
      - mongo-network
    ports:
      - "27017:27017"

networks:
  services-network:
  mysql-network:
  mongo-network:
```

## Documentation

For detailed documentation on the system's architecture, design, and implementation, please refer to the [Project Documentation (PDF)](./Data%20Analytics%20System%20Documentation.pdf).

