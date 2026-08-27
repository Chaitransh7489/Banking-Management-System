# 🏦 Core Banking Management System

> A full-stack banking operations project built with **Java 17, Spring Boot 4, Spring Data JPA, Hibernate, MySQL, and a responsive web interface**.

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-ORM-blue)](https://spring.io/projects/spring-data-jpa)
[![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-Build-C71A36)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Learning%20Project-lightgrey)](#license)

---

## 📖 Overview

**Core Banking Management System** is a Spring Boot based banking application developed to demonstrate the implementation of common banking operations through a layered backend architecture and a web-based user interface.

The system covers:

- Customer registration
- Bank account opening
- Custom account-number generation
- Account-type validation
- Cash credit and debit operations
- Balance validation
- Account verification
- Date-range transaction reporting
- Individual account reporting
- PDF report generation from the web interface

The project is designed as a practical backend-development project and demonstrates the use of **REST APIs, dependency injection, Spring Data JPA, Hibernate entity mapping, custom SQL queries, transaction management, and MySQL integration**.

> **Important:** This is an educational/portfolio project and is not intended to be used as a production banking system without substantial additional security, auditing, concurrency, compliance, and financial controls.

---

## 🎯 Project Goals

The main goals of the project are to:

1. Automate common banking operations.
2. Keep business logic separated from API and database layers.
3. Validate account and transaction operations.
4. Maintain account balances through transaction processing.
5. Provide account and transaction reporting.
6. Demonstrate practical Spring Boot backend development.

---

## ✨ Core Features

### 👤 Customer Management

- Create customer records.
- Store customer information such as:
  - Full name
  - Address
  - Mobile number
  - Gender
  - Email
  - Aadhaar
  - PAN
- Fetch customer details by customer ID.

### 🏦 Account Opening

- Validate the requested account type.
- Generate an account number using custom business logic.
- Store account opening information.
- Associate an account with a customer.
- Fetch available account types.

### 🔢 Custom Account Number Generation

The application does not simply use the database primary key as the customer-facing account number.

It uses custom logic that:

1. Builds a prefix from the branch/account-type information.
2. Reads the current maximum account sequence from the database.
3. Adds leading zeros to maintain the required format.
4. Adds the final account suffix.
5. Stores the generated account number with the account.

### 💰 Banking Transactions

The transaction service supports:

- Cash credit
- Cash debit
- Account-to-account transfer flow
- Account verification
- Transaction date recording
- Available-balance updates
- Insufficient-balance checks
- Transaction persistence

### 🛡️ Business Validation

The current implementation validates important conditions such as:

- Invalid account number
- Invalid account type
- Empty account balance
- Insufficient balance for withdrawal/debit operations

### 📊 Reporting

The application provides:

- Date-range report generation
- Individual account report generation
- Customer/account information combined with transaction information
- Credit/debit information
- Transaction type
- Transaction date
- Calculated balance information

### 📄 PDF Reports

The included web interface uses client-side JavaScript libraries to generate PDF reports from report data.

---

# 🏗️ Architecture

The backend follows a layered architecture:

```text
                     ┌──────────────────────┐
                     │       Frontend       │
                     │ HTML + JavaScript    │
                     └──────────┬───────────┘
                                │ HTTP / JSON
                                ▼
                     ┌──────────────────────┐
                     │    Controller Layer  │
                     │      REST APIs       │
                     └──────────┬───────────┘
                                │
                                ▼
                     ┌──────────────────────┐
                     │     Service Layer   │
                     │    Business Logic   │
                     └──────────┬───────────┘
                                │
                                ▼
                     ┌──────────────────────┐
                     │   Repository Layer  │
                     │ Spring Data JPA     │
                     └──────────┬───────────┘
                                │
                                ▼
                     ┌──────────────────────┐
                     │    MySQL Database   │
                     └──────────────────────┘
```

## Layer Responsibilities

### Controller Layer

The controller exposes HTTP endpoints and receives client input.

Responsibilities:

- Map HTTP requests.
- Receive JSON request bodies.
- Receive query parameters.
- Receive path variables.
- Delegate work to service classes.
- Return API responses.

### Service Layer

The service layer contains the application's business logic.

Responsibilities:

- Customer creation.
- Account opening.
- Account-number generation.
- Account validation.
- Transaction processing.
- Balance calculation/update.
- Report service coordination.

### Repository Layer

The repository layer communicates with the database through Spring Data JPA.

Responsibilities:

- CRUD operations.
- Account lookup.
- Account-type lookup.
- Transaction persistence.
- Custom SQL queries for reports.
- Account-number sequence lookup.

### Entity Layer

The entity classes represent persistent database data.

Current entities:

- `CustomerDetails`
- `accountmaster`
- `AccountTypeMaster`
- `recon`

---

# 📂 Project Structure

```text
BankingProject/
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/banking/BankingProject/
    │   │       ├── BankingProjectApplication.java
    │   │       │
    │   │       ├── Controller/
    │   │       │   └── controller.java
    │   │       │
    │   │       ├── Entity/
    │   │       │   ├── CustomerDetails.java
    │   │       │   ├── accountmaster.java
    │   │       │   ├── AccountTypeMaster.java
    │   │       │   └── recon.java
    │   │       │
    │   │       ├── Repositry/
    │   │       │   ├── BankingRepositry.java
    │   │       │   ├── BankingAccountMasterReopsitry.java
    │   │       │   ├── Accounttypemasterrepositry.java
    │   │       │   └── TransactionRepositry.java
    │   │       │
    │   │       └── Service/
    │   │           ├── CreatServic/
    │   │           ├── OpenAccountService/
    │   │           ├── Report/
    │   │           └── TranstionServic/
    │   │
    │   └── resources/
    │       ├── application.properties
    │       ├── static/
    │       │   └── index.html
    │       └── templates/
    │
    └── test/
        └── java/
            └── com/banking/BankingProject/
                └── BankingProjectApplicationTests.java
```

---

# 🛠️ Technology Stack

| Technology | Usage in the Project |
|---|---|
| **Java 17** | Core backend development |
| **Spring Boot 4.0.6** | Application framework |
| **Spring MVC / Web** | REST API development |
| **Spring Data JPA** | Repository abstraction and persistence |
| **Hibernate / JPA** | ORM and entity mapping |
| **MySQL** | Primary relational database |
| **H2** | Included as a runtime dependency for database tooling/testing scenarios |
| **Maven** | Build and dependency management |
| **HTML5** | Frontend structure |
| **JavaScript** | Frontend interaction and API calls |
| **Tailwind CSS** | Frontend styling |
| **SweetAlert2** | User notifications |
| **jsPDF + AutoTable** | Client-side PDF report generation |
| **Font Awesome** | UI icons |

---

# 🔌 REST API

The current controller exposes the following endpoints:

| HTTP Method | Endpoint | Purpose |
|---|---|---|
| `POST` | `/Create` | Create customer details |
| `GET` | `/Fetch/{id}` | Fetch customer details by ID |
| `POST` | `/Open` | Open a bank account |
| `GET` | `/GetAccountTypes` | Fetch account types |
| `POST` | `/tran` | Process a banking transaction |
| `GET` | `/VerifyAccount` | Verify account type and account number |
| `GET` | `/ReportGenreat` | Generate date-range report |
| `GET` | `/Indivisual` | Generate an individual account report |

---

# 🔄 Customer Creation Flow

```text
Client
  ↓
POST /Create
  ↓
CustomerDetails JSON
  ↓
Controller
  ↓
CreatCustomerDetails Service
  ↓
BankingRepositry
  ↓
MySQL
  ↓
Generated Customer ID
  ↓
Success Response
```

The customer service saves the supplied `CustomerDetails` entity through `BankingRepositry` and returns the generated customer ID.

---

# 🏦 Account Opening Flow

```text
Client
  ↓
POST /Open
  ↓
Account Details
  ↓
Validate Account Type
  ↓
Generate Account Number
  ↓
Set Opening Date
  ↓
Save Account
  ↓
Return Account Number
```

The account service first checks the account type using `Accounttypemasterrepositry`.

If the account type is invalid, the service returns:

```text
Invalid Account Type
```

If valid, the service generates the account number using its custom generation logic and saves the account through `BankingAccountMasterReopsitry`.

---

# 💸 Transaction Flow

The transaction endpoint is:

```text
POST /tran
```

The service performs the following high-level flow:

```text
Receive Transaction
        ↓
Find Account by Account Type + Account Number
        ↓
If Account Not Found → Return Error
        ↓
Set Transaction Date
        ↓
Read Available Balance
        ↓
Check Transaction Type
        ↓
Credit / Debit / Transfer Logic
        ↓
Validate Available Balance
        ↓
Update Account Balance
        ↓
Save Transaction
        ↓
Return Result
```

The transaction service is annotated with:

```java
@Transactional
```

This provides a transaction boundary around the transaction-processing method.

---

# 📊 Reporting Flow

The reporting service delegates report queries to `BankingAccountMasterReopsitry`.

### Date-Range Report

The application accepts:

- `fromDate`
- `toDate`

and executes a custom native SQL query that combines:

- Customer information
- Account information
- Transaction information
- Calculated balance

### Individual Account Report

The individual report additionally filters the report using:

```text
acno
```

along with the requested date range.

---

# 🧩 Important Spring/JPA Annotations

## `@SpringBootApplication`

Used on the main application class to bootstrap the Spring Boot application and combine configuration, auto-configuration, and component scanning.

## `@RestController`

Marks the controller as a REST controller and allows method return values to be written directly to the HTTP response.

## `@GetMapping`

Maps HTTP GET requests to controller methods.

## `@PostMapping`

Maps HTTP POST requests to controller methods.

## `@RequestBody`

Maps JSON data from the HTTP request body to a Java object.

## `@RequestParam`

Reads values from URL query parameters.

## `@PathVariable`

Reads values from variables embedded in the URL path.

## `@Service`

Marks a class as a Spring service containing business logic.

## `@Autowired`

Requests dependency injection from the Spring container.

## `@Entity`

Marks a Java class as a JPA entity.

## `@Table`

Maps an entity to a specific database table.

## `@Id`

Defines the primary key of an entity.

## `@GeneratedValue`

Configures automatic primary-key value generation.

## `@Query`

Defines a custom query for a repository method.

## `@Transactional`

Defines a transaction boundary for database operations.

---

# 🗃️ Repository Design

The project uses four repositories.

### `BankingRepositry`

Extends:

```java
JpaRepository<CustomerDetails, Long>
```

Used for customer CRUD operations.

### `BankingAccountMasterReopsitry`

Extends:

```java
JpaRepository<accountmaster, Long>
```

Provides:

- Account CRUD operations.
- Account lookup.
- Account-type/account-number lookup.
- Custom account-number sequence query.
- Date-range report query.
- Individual account report query.

### `Accounttypemasterrepositry`

Extends:

```java
JpaRepository<AccountTypeMaster, Long>
```

Provides account-type lookup using methods such as:

```java
findByAcctype(...)
findByAccNature(...)
```

### `TransactionRepositry`

Extends:

```java
JpaRepository<recon, Long>
```

Used to persist transaction records.

---

# 🗄️ Entity Model

## `CustomerDetails`

Stores customer information such as:

- Customer ID
- Full name
- Address
- Mobile number
- Gender
- Email
- Aadhaar
- PAN

## `accountmaster`

Stores account information such as:

- Internal account ID
- Account number
- Account type
- Customer name
- Opening date
- Closing date
- Last transaction date
- Customer ID
- Available balance

## `AccountTypeMaster`

Stores:

- Account type
- Account nature
- Branch

## `recon`

Stores transaction/reconciliation information such as:

- Account type
- Account number
- Credit amount
- Debit amount
- Transaction date
- Transaction mode
- Transaction type
- Receiver account number

---

# ⚙️ Configuration

The project uses:

```text
src/main/resources/application.properties
```

The application is configured to connect to MySQL.

For your local environment, use configuration similar to:

```properties
spring.application.name=BankingProject

spring.datasource.url=jdbc:mysql://localhost:3306/<database-name>
spring.datasource.username=<database-user>
spring.datasource.password=<database-password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
```

### ⚠️ Security Notice

**Do not commit real database passwords to a public GitHub repository.**

Before publishing this repository, replace hard-coded credentials with environment variables or another secure configuration mechanism.

The uploaded project currently contains a database password in `application.properties`; **remove/rotate that credential before making the repository public**.

---

# 🚀 How to Run

## Prerequisites

Install:

- JDK 17
- MySQL Server
- Maven (or use the included Maven Wrapper)
- Git

## 1. Clone the repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
cd BankingProject
```

## 2. Create the MySQL database

Create the database configured for the application.

Example:

```sql
CREATE DATABASE banking_db;
```

## 3. Configure database credentials

Update:

```text
src/main/resources/application.properties
```

with your local database URL, username, and password.

## 4. Build the project

Using Maven:

```bash
mvn clean install
```

Or the Maven Wrapper:

```bash
./mvnw clean install
```

On Windows:

```cmd
mvnw.cmd clean install
```

## 5. Run the application

```bash
mvn spring-boot:run
```

Or:

```bash
./mvnw spring-boot:run
```

On Windows:

```cmd
mvnw.cmd spring-boot:run
```

Then open the application in your browser using the configured local server address.

---

# 🖥️ Frontend

The project includes a static web interface at:

```text
src/main/resources/static/index.html
```

The UI provides sections for:

- Customer registration
- Account opening
- Transactions
- Reports

The frontend communicates with the Spring Boot REST APIs using JavaScript.

The interface also uses:

- Tailwind CSS
- SweetAlert2
- Font Awesome
- jsPDF
- jsPDF AutoTable

---

# 📄 Reporting and PDF Generation

The report section can retrieve transaction/report data from the backend and generate PDF output on the client side.

The frontend uses:

```text
jsPDF
jsPDF AutoTable
```

for report generation.

---

# 🧪 Testing

The project contains a Spring Boot test class under:

```text
src/test/java/com/banking/BankingProject/
```

Run tests with:

```bash
mvn test
```

or:

```bash
./mvnw test
```

---

# 🔐 Current Security Considerations

This project demonstrates banking business logic, but it should **not be considered production-grade banking software**.

For a production implementation, the following should be added:

- Authentication
- Authorization
- Role-based access control
- Password hashing
- JWT/OAuth2 security
- HTTPS
- Input validation
- Global exception handling
- Audit logging
- Rate limiting
- CSRF/CORS configuration where applicable
- Concurrency control for account balances
- Strong monetary types such as `BigDecimal`
- Idempotency for transaction requests
- Database migration/versioning
- Secrets management
- Comprehensive automated tests

---

# 📈 Future Improvements

Potential next steps:

### 🔐 Security
- Add Spring Security.
- Implement JWT authentication.
- Add roles such as Admin, Officer, and Customer.
- Secure sensitive customer information.

### 💳 Financial Integrity
- Use `BigDecimal` instead of `Long` for monetary values.
- Add concurrency/locking mechanisms.
- Add idempotency keys for transaction requests.
- Add complete transaction audit history.

### 🧱 Architecture
- Add DTOs.
- Add Mapper classes.
- Add centralized response objects.
- Improve package/class naming conventions.
- Use constructor-based dependency injection.

### 🛑 Exception Handling
- Add `@RestControllerAdvice`.
- Create custom business exceptions.
- Return standardized HTTP error responses.

### 🧪 Testing
- Add unit tests for services.
- Add repository tests.
- Add controller tests.
- Add integration tests.
- Add transaction rollback tests.

### 📚 API Documentation
- Add OpenAPI/Swagger documentation.

### 🚀 Deployment
- Dockerize the application.
- Add production configuration profiles.
- Add CI/CD with GitHub Actions.
- Deploy backend and database using a suitable cloud platform.

---

# 🧠 What This Project Demonstrates

This project demonstrates practical knowledge of:

- Java backend development
- Spring Boot
- Spring MVC
- REST APIs
- Dependency Injection
- IoC and Spring Beans
- Layered architecture
- Spring Data JPA
- Hibernate/JPA
- Entity mapping
- Repository abstraction
- Custom native SQL queries
- MySQL
- Transaction management
- Business validation
- Account-number generation
- Report generation
- Frontend-to-backend API integration

---

# 💼 Interview Summary

A concise explanation of the project:

> **“I developed a Core Banking Management System using Java, Spring Boot, Spring Data JPA, and MySQL. The system handles customer creation, account opening, custom account-number generation, cash credit and debit transactions, balance validation, account verification, and date-wise reporting. I used a layered architecture with Controller, Service, Repository, and Entity layers, and used `@Transactional` for transaction processing.”**

---

# 👨‍💻 Author

**Chaitransh Mahajan**

**Java Backend Developer**

**Skills:** Java · Spring Boot · Spring Data JPA · Hibernate · MySQL · REST API

---

# 📄 License

This repository is intended for **learning, portfolio, and demonstration purposes**.

If you decide to distribute this project as open-source software, add an appropriate license such as the MIT License and update this section accordingly.

---

## ⭐ If you find this project useful

Feel free to explore the code, raise issues, suggest improvements, or use it as a learning reference for Spring Boot backend development.
