# 📁 File Storage API (Spring Boot)

A simple backend application built using Spring Boot that allows users to upload and download files via REST API.

## 🚀 Features
- Upload files using `POST /upload`
- Download files using `GET /download/{filename}`
- Files are stored locally on the server in the `/uploads` directory.

## 📦 Tech Stack
- Java 17+
- Spring Boot
- Maven

## ▶️ How to Run

```bash
mvn spring-boot:run
```

## 📬 API Endpoints

| Method | Endpoint             | Description         |
|--------|----------------------|---------------------|
| POST   | `/upload`            | Upload a file       |
| GET    | `/download/{filename}` | Download a file by name |

## 📝 Author
Your Name • [GitHub](https://github.com/yourusername)