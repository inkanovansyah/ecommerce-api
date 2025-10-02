# 🛒 Ecommerce API

Ecommerce API adalah backend service berbasis **Java Spring Boot** yang dirancang untuk mendukung kebutuhan aplikasi e-commerce, mulai dari manajemen produk, pengguna, hingga transaksi.  
Proyek ini mengikuti arsitektur **layered architecture** (Controller → Service → Repository) dengan dukungan exception handling yang terstruktur.

---

## 🔧 Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA / Hibernate
- Maven
- MySQL / PostgreSQL
- Lombok

---

## 📂 Project Structure

ecommerce-api/
┣ src/main/java/com/example/ecommerce
┃ ┣ controller/ # REST API Layer
┃ ┣ service/ # Business Logic Layer
┃ ┣ repository/ # Data Access Layer
┃ ┣ exception/ # Global Exception Handler & Custom Exceptions
┃ ┗ model/ # Entity, DTO, and Request/Response Objects
┣ pom.xml # Maven configuration
┗ README.md


---

## 🚀 Getting Started

### 1. Clone Repository
```bash
git clone https://github.com/inkanovansyah/ecommerce-api.git
cd ecommerce-api

2. Setup Database

Buat database baru di MySQL/PostgreSQL, lalu sesuaikan konfigurasi di:

src/main/resources/application.properties

Contoh konfigurasi:

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3. Run Application

./mvnw spring-boot:run

Aplikasi akan berjalan di:

http://localhost:8080

📌 Features

    User Management (Register, Login, Authentication)

    Product Management (CRUD Produk)

    Transaction & Order Management

    Global Exception Handling

    DTO & Validation Support

🧪 API Documentation

Jika Swagger diaktifkan:

    Swagger UI: http://localhost:8080/swagger-ui.html

    OpenAPI Spec: http://localhost:8080/v3/api-docs

🤝 Contribution

    Fork repository ini

    Buat branch baru: feature/namafitur

    Commit perubahan

    Buat Pull Request ke branch master
