# Java_online_exam_dashboard
java
# Online Exam Dashboard

A simple Java / Spring Boot application acting as an online exam dashboard. Includes REST APIs to list exams etc. This project also demonstrates CI/CD integration using Jenkins, code quality & security scans (SonarQube & OWASP Dependency-Check), Dockerization.

---

## Features

- REST API: Get list of exams, get exam details  
- In-memory data store (can replace with persistent DB)  
- Unit tests + code coverage (JaCoCo)  
- Security scanning of dependencies (OWASP Dependency-Check)  
- Static code quality analysis via SonarQube  
- Docker image for deployment

---

## Requirements

- Java 17  
- Maven  
- Docker  
- Jenkins  
- SonarQube server  
- OWASP Dependency-Check plugin in Jenkins

---

## Setup Locally

1. Clone the repo  
   ```bash
   git clone https://github.com/<your-username>/online-exam-dashboard.git
   cd online-exam-dashboard

