# 🛒 Ecommerce API

Backend service berbasis **Java + Spring Boot** untuk mendukung aplikasi e-commerce.  
Menyediakan fitur manajemen pengguna, produk (menu), vendor, dan pemesanan (order).

---

## ⚙️ Tech Stack

- Java 21+  
- Spring Boot  
- Spring Data JPA / Hibernate  
- MySQL / PostgreSQL  
- Maven  
- Lombok  
- (Opsional) Swagger / OpenAPI untuk dokumentasi API  

---

## 📂 Struktur Proyek

ecommerce-api/
├── src/
│   └── main/java/com/example/ecommerce/
│       ├── controller/     # Endpoint / API layer
│       ├── service/        # Logika bisnis
│       ├── repository/     # Akses database
│       ├── exception/      # Handler & custom exception
│       └── model/          # Entity, DTO, Request/Response
├── pom.xml                 # Konfigurasi Maven
└── README.md

---

## 🚀 Cara Menjalankan

1. Clone repository

   git clone https://github.com/inkanovansyah/ecommerce-api.git  
   cd ecommerce-api

2. Buat database (contoh: `ecommerce_db`) di MySQL/PostgreSQL.  
   Sesuaikan konfigurasi di `src/main/resources/application.properties`:

   spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db  
   spring.datasource.username=root  
   spring.datasource.password=yourpassword  
   spring.jpa.hibernate.ddl-auto=update

3. Jalankan aplikasi:

   ./mvnw spring-boot:run  

   Aplikasi tersedia di: http://localhost:8080

---

## 📦 Fitur Utama

- ✅ Manajemen pengguna (registrasi, login, autentikasi)  
- ✅ CRUD produk / menu  
- ✅ Manajemen vendor  
- ✅ Pemesanan & transaksi  
- ✅ Validasi DTO + global exception handler  
- ✅ (Opsional) Dokumentasi API via Swagger  

---

## 🔗 API Endpoint

### 1. Get Menus
GET https://ecommerce-api-production-9b6a.up.railway.app/api/menus?page=0&size=10

Response:
{
  "content": [
    {
      "id": 1,
      "name": "Nasi Goreng Spesial",
      "price": 25000,
      "description": "Nasi goreng dengan topping spesial",
      "vendorId": 1
    }
  ],
  "pageable": { ... }
}

---

### 2. Get Vendors
GET https://ecommerce-api-production-9b6a.up.railway.app/api/vendors?page=0&size=10

Response:
{
  "content": [
    {
      "id": 1,
      "name": "Warung Bang Joko",
      "address": "Jakarta Pusat",
      "phone": "08123456789"
    }
  ],
  "pageable": { ... }
}

---

### 3. Create Order
POST https://ecommerce-api-production-9b6a.up.railway.app/api/orders  
Content-Type: application/json  

Request:
{
  "userId": 1,
  "vendorId": 1,
  "orderId": "1759079859268",
  "customerNotes": "pake sambel bang",
  "deliveryAddress": "Jl. sana kanan dikit No. 123, Jakarta Pusat",
  "items": [
    {
      "menuId": 1,
      "menuName": "Nasi Goreng Spesial",
      "quantity": 2,
      "price": 25000
    },
    {
      "menuId": 2,
      "menuName": "Es Teh Manis",
      "quantity": 2,
      "price": 5000
    }
  ],
  "payment": {
    "method": "transfer",
    "totalAmount": 60000,
    "status": "pending"
  }
}

Response:
{
  "status": "success",
  "message": "Order berhasil dibuat",
  "data": {
    "orderId": "1759079859268",
    "totalAmount": 60000,
    "paymentStatus": "pending"
  }
}

---

## 🤝 Kontribusi

1. Fork repo ini  
2. Buat branch fitur: `feature/nama-fitur`  
3. Commit perubahan  
4. Push branch  
5. Buat Pull Request  

---

## 📄 Lisensi



