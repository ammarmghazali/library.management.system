Library Management System
Overview
The Library Management System is a Spring Boot application designed to manage library operations, including book registration, borrower management, and more. This project demonstrates basic CRUD operations and validation with a focus on clean code and best practices.

Technologies Used:
Java Version : 17
Spring Boot: For building the backend application.
Spring Data JPA: For data access and persistence.
H2 Database: Used as the in-memory database for development and testing purposes.
Swagger: For API documentation and testing.
Documentation : Javadoc.

Getting Started

Prerequisites
Java 11 or higher
Maven (for building the project)

Clone the Repository
git clone https://github.com/yourusername/library-management-system.git

cd library-management-system
Build the Project

Using Maven: mvn clean install

Database Configuration
Currently, the application uses an H2 in-memory database for development and testing purposes. H2 is a lightweight, fast, and easy-to-setup database that allows for quick development cycles without needing an external database setup.

H2 Database: It provides an embedded database for local development. This simplifies the development setup and allows for quick testing without additional configuration.

Accessing the H2 Database Console
Open your browser and go to: http://localhost:8080/h2-console

Configure the Connection:

JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: password
Click Connect to access the H2 console.

Migrating to MySQL
Migrating from H2 to MySQL is straightforward. Follow these steps:

Update application.properties:

Replace the H2 datasource configuration with MySQL configuration.

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Add MySQL Dependency:

In your pom.xml (for Maven):

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

Create the MySQL Database:
Ensure that you have a MySQL database named librarydb created on your MySQL server.

Restart the Application:
The application should now connect to MySQL instead of H2.

Accessing Swagger UI
Open your browser and go to: http://localhost:8080/swagger-ui.html

Swagger UI provides an interactive interface to test and explore your API endpoints. You can view all available endpoints and make API calls directly from this interface.

API Endpoints
Borrower Endpoints
Register a Borrower:

URL: /borrower/register
Method: POST
Request Body: RegisterBorrowerRequest (must include valid email)
Response: Borrower

Get All Borrowers:
URL: /borrower/get
Method: GET
Response: List<Borrower>

Register a Book:
URL: /book/register
Method: POST
Request Body: RegisterBookRequest
Response: Book

Get All Books:
URL: /book/get
Method: GET
Response: List<Book>

Borrow a Book:
URL: /book/{bookId}/borrow
Method: PUT
Request Body: Borrower
Path Variable: bookId (ID of the book to borrow)
Response: Book

Return a Book:
URL: /book/{bookId}/return
Method: PUT
Path Variable: bookId (ID of the book to return)
Response: Book

Contributing
If you’d like to contribute to this project, please fork the repository, make your changes, and submit a pull request. Ensure that you follow the coding standards and write tests for new features.

Contact
For any questions or issues, please contact:

Your Name: ammarmghazali@gmail.com
