# Order Management Enquiry System

A full-stack POC application for managing and viewing order details. Built with **Spring Boot** (backend) and **React** (frontend), connected to a **PostgreSQL** database.

---

## Tech Stack

| Layer    | Technology                          |
|----------|-------------------------------------|
| Backend  | Java 17, Spring Boot 3.5, REST APIs |
| ORM      | JPA / Hibernate                     |
| Database | PostgreSQL                          |
| Frontend | React 19, Vite                      |

---

## Project Structure

```
ordermanagement/
├── backend/
│   ├── src/main/java/com/example/ordermanagement/
│   │   ├── entity/             # Order entity & OrderStatus enum
│   │   ├── dto/                # Request/response DTOs
│   │   ├── repository/         # JPA repository with search queries
│   │   ├── service/            # Business logic layer
│   │   ├── controller/         # REST API endpoints
│   │   ├── exception/          # Global error handling
│   │   └── config/             # CORS config
│   ├── src/main/resources/
│   │   └── application.properties
│   ├── pom.xml
│   ├── .env                    # Environment variables (not committed)
│   └── .env.example            # Template for env variables
│
├── frontend/
│   ├── src/
│   │   ├── components/         # SearchBar, OrderTable, OrderDetail
│   │   ├── services/           # API service (fetch calls)
│   │   ├── App.jsx             # Main application component
│   │   ├── App.css             # Application styles
│   │   └── main.jsx            # Entry point
│   ├── .env                    # Environment variables (not committed)
│   ├── .env.example            # Template for env variables
│   └── package.json
│
└── README.md
```

---

## API Endpoints

| Method | Endpoint                        | Description                          |
|--------|---------------------------------|--------------------------------------|
| GET    | `/api/orders`                   | Get all orders                       |
| GET    | `/api/orders/{id}`              | Get order by ID                      |
| GET    | `/api/orders/number/{orderNo}`  | Get order by order number            |
| GET    | `/api/orders/search?keyword=`   | Search by order number/customer/product |

---

## Prerequisites

- Java 17
- Maven 3.8+
- Node.js 18+
- PostgreSQL 14+

---

## Setup & Run

### 1. Database Setup

```bash
sudo -u postgres psql -c "CREATE DATABASE ordermanagement;"
sudo -u postgres psql -c "CREATE USER orderuser WITH PASSWORD 'orderpass123';"
sudo -u postgres psql -c "GRANT ALL PRIVILEGES ON DATABASE ordermanagement TO orderuser;"
```

After first backend start (creates table), load sample data:

```bash
psql -U orderuser -d ordermanagement -f backend/src/main/resources/data.sql
```

### 2. Backend

```bash
cd backend

# Create .env from template
cp .env.example .env
# Edit .env with your DB credentials

# Run the application
./mvnw spring-boot:run
```

Backend starts at: `http://localhost:8080`

On first run, Hibernate auto-creates the `orders` table. Insert sample rows with `data.sql` (see above).

### 3. Frontend

```bash
cd frontend

# Create .env from template
cp .env.example .env

# Install dependencies
npm install

# Run dev server
npm run dev
```

Frontend starts at: `http://localhost:5173`

---

## Environment Variables

### Backend (`backend/.env`)

| Variable     | Description              | Default          |
|--------------|--------------------------|------------------|
| DB_HOST      | PostgreSQL host          | localhost        |
| DB_PORT      | PostgreSQL port          | 5432             |
| DB_NAME      | Database name            | ordermanagement  |
| DB_USERNAME  | Database username        | orderuser        |
| DB_PASSWORD  | Database password        | orderpass123     |
| JPA_DDL_AUTO | Hibernate DDL strategy   | update           |
| JPA_SHOW_SQL | Log SQL queries          | true             |

### Frontend (`frontend/.env`)

| Variable          | Description     | Default                    |
|-------------------|-----------------|----------------------------|
| VITE_API_BASE_URL | Backend API URL | http://localhost:8080/api   |

---

## Features

- **Search Orders** — Search by order number, customer name, or product
- **View Order Details** — Click any order to see full details in a modal
- **Error Handling** — Global exception handler with proper HTTP status codes
- **Sample Data** — SQL script in `backend/src/main/resources/data.sql`
- **CORS Configured** — Backend allows frontend origin
- **Environment Variables** — No secrets hardcoded in source

---

## Sample Data

Run `data.sql` to load 10 sample orders:

| Order #        | Customer       | Product                    | Status     |
|----------------|----------------|----------------------------|------------|
| ORD-2024-001   | Rahul Sharma   | Laptop - Dell Inspiron 15  | DELIVERED  |
| ORD-2024-002   | Priya Patel    | Samsung Galaxy S24 Ultra   | SHIPPED    |
| ORD-2024-003   | Amit Kumar     | Sony WH-1000XM5 Headphones| PROCESSING |
| ORD-2024-004   | Sneha Reddy    | Apple MacBook Air M3       | CONFIRMED  |
| ORD-2024-005   | Vikram Singh   | LG 55-inch OLED TV         | PENDING    |
| ...            | ...            | ...                        | ...        |

---

## Architecture

```
Frontend (React)  →  fetch()  →  Backend (Spring Boot REST)  →  JPA/Hibernate  →  PostgreSQL
```

- **Controller** — Handles HTTP requests, returns ResponseEntity
- **Service** — Business logic, throws custom exceptions
- **Repository** — JPA interface with derived query methods
- **GlobalExceptionHandler** — Catches exceptions, returns structured JSON errors
