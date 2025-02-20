# 🛒 Spring Boot Microservices E-Commerce Backend

This project is a microservices-based backend built using Java and Spring Boot. It supports product management, order processing, inventory tracking, and notifications. The services communicate via Kafka, are secured with Keycloak, and monitored using OpenTelemetry and Grafana.


## 🚀 Technologies Used

<div align="center">
  
### **Services**
<img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white" height="50"> &nbsp;
<img src="https://img.shields.io/badge/Spring%20Web-6DB33F?logo=spring&logoColor=white" height="50">


### **Containerization & Orchestration**
<img src="https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white" height="50"> &nbsp;
<img src="https://img.shields.io/badge/Kubernetes-326CE5?logo=kubernetes&logoColor=white" height="50">


### **Authentication & Messaging**
<img src="https://img.shields.io/badge/Keycloak-0078D7?logo=keycloak&logoColor=white" height="50"> &nbsp;
<img src="https://img.shields.io/badge/Apache%20Kafka-231F20?logo=apachekafka&logoColor=white" height="50">


### **Databases**
<img src="https://img.shields.io/badge/MongoDB-47A248?logo=mongodb&logoColor=white" height="50"> &nbsp;
<img src="https://img.shields.io/badge/PostgreSQL-336791?logo=postgresql&logoColor=white" height="50">


### **Service Discovery**
<img src="https://img.shields.io/badge/Eureka-FFCA28?logo=spring&logoColor=black" height="50">


### **Monitoring & Telemetry**
<img src="https://img.shields.io/badge/OpenTelemetry-59666C?logo=opentelemetry&logoColor=white" height="50"> &nbsp;
<img src="https://img.shields.io/badge/Grafana-F46800?logo=grafana&logoColor=white" height="50">

</div>

---

**💡 Key Highlights:**  
- **Spring Boot & Spring Web:** Core frameworks for building robust microservices.  
- **Kafka & Keycloak:** Asynchronous messaging and secure user authentication.  
- **MongoDB & PostgreSQL:** Efficient data storage with both NoSQL and SQL options.  
- **Docker & Kubernetes:** Seamless deployment and scaling.  
- **Eureka:** Service discovery for inter-service communication.  
- **OpenTelemetry & Grafana:** Real-time monitoring and tracing.  

---

## 📂 Microservices Overview

1. **🛍️ Product Service (MongoDB)**  
   - Stores and manages product information using MongoDB.  
   - Provides endpoints for product CRUD operations.

2. **📦 Inventory Service (PostgreSQL)**  
   - Tracks product stock levels using PostgreSQL.  
   - Ensures stock availability before order placement.

3. **🧾 Order Service (PostgreSQL)**  
   - Handles order creation, payment, and status updates.  
   - Communicates with Inventory Service to validate stock.

4. **📢 Notification Service (Stateless)**  
   - Sends notifications via email, SMS, or push notifications.  
   - Stateless design ensures high scalability.

5. **🌐 API Gateway**  
   - Acts as a single entry point for all client requests.  
   - Routes requests to respective services and manages authentication with Keycloak.

6. **🗂️ Service Registry (Eureka)**  
   - Keeps track of all available services for dynamic discovery.  
   - Ensures seamless communication between microservices.

---

## ✅ Features
- Secure authentication using Keycloak.
- Asynchronous communication using Kafka.
- Service discovery and load balancing using Eureka.
- Containerized deployment with Docker and Kubernetes.
- Monitoring and tracing with OpenTelemetry and Grafana.

---

## 🐳 Deployment Using Docker Compose

```bash
docker-compose up -d
```

---

## 📚 Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Kubernetes Documentation](https://kubernetes.io/docs/home/)
- [Keycloak Documentation](https://www.keycloak.org/documentation.html)
- [MongoDB Documentation](https://docs.mongodb.com/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Apache Kafka Documentation](https://kafka.apache.org/documentation/)


---

## 📝 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.



