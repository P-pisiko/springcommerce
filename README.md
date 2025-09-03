# SpringCommerce — Spring Boot E-commerce

A minimal, pragmatic Spring Boot e-commerce

Structure: product catalog, authentication, cart & order basics, and a MySQL schema that maps the core domain.


## Showcase

<div style="display:flex; gap:16px; align-items:flex-start;">
  <div style="flex:1; text-align:center;">
    <img src="https://raw.githubusercontent.com/P-pisiko/springcommerce/main/imgs/landing.jpg" alt="Main page" style="width:100%; max-width:560px; border-radius:8px; box-shadow:0 2px 8px rgba(0,0,0,0.1)"/>
    <p><strong>Main page</strong></p>
  </div>
  <div style="flex:1; text-align:center;">
    <img src="https://raw.githubusercontent.com/P-pisiko/springcommerce/main/imgs/login.png" alt="Login form" style="width:100%; max-width:560px; border-radius:8px; box-shadow:0 2px 8px rgba(0,0,0,0.1)"/>
    <p><strong>Login form</strong></p>
  </div>
</div>

---

## Table of contents

- [About](#about)
- [Features](#features)
- [Tech stack](#tech-stack)
- [Database design (MySQL)](#database-design-mysql)
- [Diagrams](#diagrams)
- [Getting started](#getting-started)
- [Database migration / schema files](#database-migration--schema-files)
- [Run](#run)



## About

#### Spring Boot based e-commerce reference/demo application.



## Features

- Product catalog
- User authentication (login form shown above)
- Shopping cart and basic order flow (starter implementation)
- MySQL-backed persistence with clear schema and migration files included
- Frontend views for basic UX (landing page, login, product listing)

---

## Tech stack

- Java + Spring Boot (Web, JDBC-Template, Spring-Security)
- MySQL (relational schema designed in MySQL Workbench)
- Thymeleaf HTML templates
- Build: Maven or Gradle (see project files)

---

## Database design (MySQL)

The app persists its domain model in MySQL. The design favors normalized tables for users, products, categories, carts, orders, and order items. Typical relationships:

- `users` — primary user table (authentication & profile data)
- `products` — product metadata, price, stock, JSON column for image names if present
- `item` — item table containing information about listed itesm
- `orders` / `order_items` — finalized orders and the items they contain
- FK constraints ensure referential integrity; indexes added on fields used in lookups (username/email, product_id, order_id)


## Diagrams

Database ER diagrams (visual):

<div style="display:flex; gap:16px; align-items:flex-start;">
  <div style="flex:1; text-align:center;">
    <img src="https://raw.githubusercontent.com/P-pisiko/springcommerce/main/database/schema/Model%20databases.png" alt="DB Model databases" style="width:100%; max-width:560px; border-radius:6px; box-shadow:0 2px 6px rgba(0,0,0,0.12)"/>
    <p><strong>Model databases.png</strong></p>
  </div>
  <div style="flex:1; text-align:center;">
    <img src="https://raw.githubusercontent.com/P-pisiko/springcommerce/main/database/schema/mysqlWorkbenh-scheema.jpg" alt="MySQL Workbench schema" style="width:100%; max-width:560px; border-radius:6px; box-shadow:0 2px 6px rgba(0,0,0,0.12)"/>
    <p><strong>MySQL Workbench schema</strong></p>
  </div>
</div>

## Getting started

1. **Clone the repo**

```bash
git clone https://github.com/P-pisiko/springcommerce.git
cd springcommerce
```

2. **Java & build tool**  
   Java 17+

3. **Configure MySQL**  
   Create a database:

```sql
CREATE DATABASE ecommerce CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

4. **Import schema**

```bash
mysql -u root -p springcommerce < database/migration/ecommerce-schema.sql
```

- Or open `database/migration/Ecommerce-Schema.mwb` in MySQL Workbench and export/apply the SQL.

---

## Database migration / schema files

Files included in the repo:

- SQL: `database/migration/ecommerce-schema.sql`
- MWB: `database/migration/Ecommerce-Schema.mwb`
- `database/schema/Model databases.png` — ER diagram image (visual).
- `database/schema/mysqlWorkbenh-scheema.jpg` — Workbench export image.

---

## Environment / application properties

Set your `application.properties`:

```properties
# datasource
spring.application.name=ecommerce
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=your_username
spring.datasource.password=your_mysql_password
# JPA / Hibernate
spring.jpa.show-sql=true
spring.datasource.hikari.pool-name=HikariCP
#logging.level.org.springframework.security=DEBUG
```

## Build & Run

If Maven:

```bash
mvn clean package
mvn spring-boot:run
```

If Gradle:

```bash
./gradlew bootRun
```

Or run the generated jar:

```bash
java -jar target/<artifact>.jar
```
