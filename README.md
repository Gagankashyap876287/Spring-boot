# Spring-boot
Web app using Spring Boot &amp; Thymeleaf for managing customers.
# CRUD Application with Spring Boot and Thymeleaf

This project implements a basic CRUD (Create, Read, Update, Delete) program using Thymeleaf and Spring Boot to manage a database of customers.

## Setup

1. Clone this repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Create a MySQL database and configure the connection settings in `application.properties`.
4. Run the application using Maven: `mvn spring-boot:run`.
5. Access the application at `http://localhost:8080/customers/list`.

## Features

### Reading Customers

The program reads from the database a list of customers.

### Creating a New Customer

To add a new customer, click the "Add Customer" button. You will be redirected to a form to fill in the new customer's data. After filling in the details, click the "Save" button to save the customer to the database, and you will be redirected to the main list.

### Updating an Customer

To update an customer, click the "Update" button next to the customer you want to edit. You will be directed to the update form where all fields will be pre-filled with the customer's data. Make any necessary changes and click "Save". You will then be redirected to the main list.

### Deleting an Customer

Clicking the "Delete" button will prompt a confirmation pop-up. If you confirm deletion, the customer will be removed from the database, and the list will be updated accordingly.

<h3>Pagination and Sorting</h3>


## Technologies Used

- Spring Boot
- Thymeleaf
- Spring Boot Web
- Spring Boot Devtools
- MySQL Connector

## Credits

This project was created using the Spring Initializr: [https://start.spring.io/](https://start.spring.io/)


