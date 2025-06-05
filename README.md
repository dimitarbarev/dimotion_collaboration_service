# 🤝 Dimotion Collaboration Service

A Spring Boot microservice for managing users, teams, boards, and textboxes within the Dimotion platform.

---

## 📦 Features

- Manage user registration and team associations
- Create and organize boards per team
- Add textboxes to boards
- Link users to boards and teams (many-to-many)

---

## 🚀 How It Works

1. A user can join multiple teams and collaborate on shared boards.
2. Boards are owned by teams and contain interactive elements like textboxes.
3. Textboxes store data (e.g. notes, comments) and are placed on boards by users.

> 📘 All data is stored in the `dimotion_collaboration_db` MySQL database.

---

## 🔧 API Structure (Example)

| Entity   | Endpoints                                |
|----------|-------------------------------------------|
| Users    | `/api/users`, `/api/users/{id}`          |
| Teams    | `/api/teams`, `/api/teams/{id}`          |
| Boards   | `/api/boards`, `/api/boards/{id}`        |
| Textboxes| `/api/textboxes`, `/api/textboxes/{id}`  |

---

## 🐳 Docker

To run the service with Docker:

```bash
docker-compose up --build
```

Make sure your `application.properties` is configured like:

```properties
spring.datasource.url=jdbc:mysql://mysql:3306/dimotion_collaboration_db
spring.datasource.username=user
spring.datasource.password=pass

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8081
```

## 🧪 Testing

Run all tests using:
```bash
./gradlew test
```
JUnit 5 is used to validate the logic for user, board, team, and textbox interactions.

## 🧠 Notes
- Written in Java 17 using Spring Boot 3

- Lombok used to reduce boilerplate

- Uses JPA for ORM with custom repositories where needed

- Part of the Dimotion microservice architecture

## 👨🏻‍💻 Changes in the code

```
./gradlew clean build
docker compose build --no-cache collaboration-service
docker compose up
```

## 🤝 License

MIT License © [Dimitar Barev](https://github.com/dimitarbarev)
