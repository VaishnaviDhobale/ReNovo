# ReNovo – Second-Hand & Upcycled Goods Marketplace (Backend)

ReNovo is a backend REST API built using **Spring Boot** that powers a marketplace platform for buying and selling second-hand and upcycled goods. The goal is to promote sustainable living by making it easier for users to give products a second life.

## 🚀 Features

- User authentication and authorization (buyers and sellers)
- CRUD operations for products
- Product categorization (e.g., furniture, fashion, electronics, etc.)
- Filtering and search capabilities
- Seller profile and product management
- Wishlist and favorites
- Order management (basic)
- Admin panel endpoints for moderation

## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security with JWT**
- **MySQL / PostgreSQL** (You can choose one)
- **Lombok**
- **Maven**
- **Swagger/OpenAPI** for API documentation

## 📂 Project Structure
```  
ReNovo/
├── src/
│ ├── main/
│ │ ├── java/com/renovo/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── security/
│ │ └── resources/
│ │ ├── application.properties
│ │ └── ...
└── pom.xml
```