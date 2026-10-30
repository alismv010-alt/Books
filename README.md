# 📚 BooKitab

**A marketplace idea for books: buy and sell, new and second-hand.**

BooKitab is built so that people can **buy books** and **sell their own books**. A seller can list a brand-new (first-hand) book or a used (second-hand) book. For second-hand books the seller also says what condition the book is in. 


## ✨ Idea

- Anyone can browse books from sellers.
- Anyone can sell: put up a **new** book or a **used** one.
- Used books show their **condition** (`Poor`, `Fair`, `New`), so the buyer knows what to expect.
- Books will have **photos** (up to 5 per book) and a **short description**.

## 🚦 Project status

BooKitab is in active development. Here is what works today and what is coming.

**Works now**

- Book catalog with full CRUD (create, read, update, delete)
- First-hand / second-hand books, with a condition for second-hand books
- Authors: list and details
- Search by title, author name, price and ID
- Sorting and pagination (5 books per page in the web UI)
- Input validation and clear error messages
- Swagger / OpenAPI documentation
- Simple web interface (plain HTML, CSS and JavaScript)

**Coming next** (see the [roadmap](#-roadmap))

- Book photos (up to 5 per book)
- Short book description
- User accounts, so people can sell and buy

---

## 🧰 Tech stack

| Part | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.1.1 (Web MVC, Data JPA, Validation) |
| Database | MySQL |
| Mapping | MapStruct (Entity ↔ DTO) |
| Boilerplate | Lombok |
| API docs | springdoc-openapi (Swagger UI) |
| Build tool | Gradle |
| Frontend | HTML, CSS, JavaScript (no framework, no build step) |

## 🏗️ How the project is organized

The backend uses a layered design: **Controller → Service → Repository → Database**. Requests and responses use **DTOs**, while the database uses **Entities**. MapStruct converts between them.

```
BooKitab
├── src/main
│   ├── java/Book
│   │   ├── controller          REST endpoints
│   │   ├── controllerAdvicer   global error handling (@ControllerAdvice)
│   │   ├── dto                 request / response objects
│   │   ├── entity              database entities
│   │   ├── mapStruct           Entity ↔ DTO mappers
│   │   ├── repository          Spring Data JPA repositories
│   │   ├── service             business logic
│   │   └── specification       dynamic search filters
│   └── resources
│       ├── application.properties
│       └── static              web interface (index.html, authors.html, ...)
├── build.gradle
└── README.md
```

---

## 🚀 Getting started

### Requirements

- Java 21
- MySQL 8 (or newer)
- Git

### 1. Clone the project

```bash
git clone https://github.com/alismv010-alt/BooKitab.git
cd BooKitab
```

### 2. Create the database

The app does **not** create tables by itself (`ddl-auto=none`), so create them first. Here is an example schema. Make sure the names match your entity mappings.

```sql
CREATE DATABASE bookitab CHARACTER SET utf8mb4;
USE bookitab;

CREATE TABLE authors (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  dateofbirth DATE NULL,
  dateofdeath DATE NULL
);

CREATE TABLE books (
  idBooks INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(45) NOT NULL,
  author_id INT NOT NULL,
  price FLOAT NOT NULL,
  is_second_hand BOOLEAN NOT NULL DEFAULT FALSE,
  book_condition ENUM('POOR', 'FAIR', 'NEW') NULL,
  CONSTRAINT fk_books_author FOREIGN KEY (author_id) REFERENCES authors(id),
  -- a condition is required for second-hand books and must be empty for new ones
  CONSTRAINT chk_book_condition CHECK (
    (is_second_hand = 0 AND book_condition IS NULL)
    OR (is_second_hand = 1 AND book_condition IS NOT NULL)
  )
);
```

> The `CHECK` rule needs MySQL 8.0.16 or newer.

### 3. Configure the app

Open `src/main/resources/application.properties` and set your database. The username and password are read from **environment variables**, so no secrets are stored in the code.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookitab
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=none
server.servlet.context-path=/Library
```

Set the variables before you run the app.

Windows (PowerShell):
```powershell
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_password"
```

macOS / Linux:
```bash
export DB_USERNAME=root
export DB_PASSWORD=your_password
```

In IntelliJ IDEA you can instead add them in **Run → Edit Configurations → Environment variables**.

### 4. Run

```bash
./gradlew bootRun
```

On Windows: `gradlew.bat bootRun`

### 5. Open it

| What | Address |
|---|---|
| Web interface | http://localhost:8080/Library/index.html |
| Swagger UI (API docs) | http://localhost:8080/Library/swagger-ui/index.html |
| OpenAPI JSON | http://localhost:8080/Library/v3/api-docs |

---

## 🔌 REST API

Base address: `http://localhost:8080/Library`

| Method | Endpoint | What it does |
|---|---|---|
| `GET` | `/books` | List books (with filters, sorting and pagination) |
| `POST` | `/books` | Add a book |
| `PUT` | `/books` | Update a book |
| `DELETE` | `/books?id={id}` | Delete a book |
| `GET` | `/authors` | List all authors |
| `GET` | `/authors/{id}` | Get one author |

### Search, sort and pagination

`GET /books` accepts these optional query parameters:

| Parameter | Meaning |
|---|---|
| `title` | Part of the book title |
| `authorName` | Part of the author's name or surname |
| `price` | Exact price |
| `id` | Book ID |
| `page` | Page number, starting from `0` |
| `size` | Books per page |
| `sort` | For example `price,asc` or `title,desc` |

Example:

```
GET /Library/books?authorName=nizami&sort=price,asc&page=0&size=5
```

### Add a book

A second-hand book needs a `condition` (`POOR`, `FAIR` or `NEW`). A first-hand book must not have one.

```http
POST /Library/books
Content-Type: application/json

{
  "title": "Khamsa",
  "price": 12.5,
  "secondHand": true,
  "condition": "FAIR",
  "authorId": { "id": 1 }
}
```

### Errors

Errors are returned in a clear format by a global `@ControllerAdvice`:

- `400 Bad Request`: validation failed. The body shows which field is wrong and why.
- `404 Not Found`: the book or author does not exist.

---

## 🖥️ Web interface

The frontend is simple on purpose: plain HTML, CSS and JavaScript in `src/main/resources/static`. Spring Boot serves it, so there is nothing extra to install.

- Book cards with title, type (first-hand / second-hand), condition, price and author
- Search, sorting and pagination (5 books per page)
- Add, edit and delete books (delete asks "Are you sure?")
- Adding a book is **click-only** at the start: first choose *First-hand* or *Second-hand*, and for second-hand books then choose *New*, *Fair* or *Poor*
- Author search while you type
- Authors page with details for each author

---

## 🗺️ Roadmap

- [x] Book CRUD
- [x] Authors
- [x] Search, sorting and pagination
- [x] Validation and global error handling
- [x] Swagger / OpenAPI
- [x] First-hand and second-hand books with condition
- [ ] Book photos (up to 5 per book)
- [ ] User accounts and login
- [ ] Sellers manage their own listings
- [ ] Buying flow (orders)
- [ ] Environment profiles (dev / prod), logging and Actuator
- [ ] Automated tests and Docker support

---

## 👤 Author

Made by [@alismv010-alt](https://github.com/alismv010-alt).

Ideas and suggestions are welcome. Open an issue to share them.
