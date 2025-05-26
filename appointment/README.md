
## 📘 `README.md` – Doctor Appointment System (Spring Boot + MySQL)

```markdown
# 🩺 Doctor Appointment System – Spring Boot Project

A RESTful Java backend for managing doctor appointments. Built using Spring Boot, MySQL, and JPA with support for CRUD operations for doctors, patients, and appointments.

---

## 📦 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- MySQL 8.x
- Maven
- REST APIs
- (Optional: Swagger, Docker)

---

## 📁 Project Structure

```

src/main/java/com/doctor/appointment
├── controller       // REST Controllers
├── entity           // Entity classes (Doctor, Patient, Appointment)
├── repository       // JPA repositories
├── service          // Business logic
└── AppointmentApplication.java  // Main class

````

---

## ⚙️ Setup Instructions

### ✅ Prerequisites
- JDK 17+
- Maven
- MySQL 8.x running locally
- IntelliJ IDEA or any Java IDE

---

### 🔧 MySQL Setup

Create the database:
```sql
CREATE DATABASE doctor_db;
````

Set your MySQL username/password in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/doctor_db
spring.datasource.username=root
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### ▶️ Running the App

In the project root, use:

```bash
mvn spring-boot:run
```

Or run `AppointmentApplication.java` directly in IntelliJ.

---

## 📬 API Endpoints

### 🧑‍⚕️ Doctors

* `POST /doctors` — Add doctor
* `GET /doctors` — List all
* `GET /doctors/{id}` — Get by ID
* `PUT /doctors/{id}` — Update
* `DELETE /doctors/{id}` — Delete

### 🧍‍♂️ Patients

* `POST /patients` — Add patient
* `GET /patients` — List all
* `GET /patients/{id}` — Get by ID
* `PUT /patients/{id}` — Update
* `DELETE /patients/{id}` — Delete

### 📅 Appointments

* `POST /appointments` — Book appointment
  **JSON Body:**

  ```json
  {
    "doctorId": "1",
    "patientId": "2",
    "appointmentDateTime": "2025-05-28T10:30:00"
  }
  ```
* `GET /appointments` — List all
* `GET /appointments/{id}` — Get by ID
* `DELETE /appointments/{id}` — Cancel

---

## ❗ Notes

* No double-booking: A doctor or patient cannot be booked at the same time.
* Uses `@ManyToOne` JPA mappings between appointments and doctors/patients.
* All APIs return JSON.

---

## 💾 Database Dump

Include `doctor_db.sql` in your repo for easy setup.

---

## 🧪 (Optional) Swagger UI

Add the dependency below to `pom.xml` and visit `/swagger-ui/index.html`:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
```


