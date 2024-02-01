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
![image](https://github.com/Gagankashyap876287/Spring-boot/assets/121686792/ad4fd2c4-6453-4f34-99c4-12a6a0dfd49b)


### Creating a New Customer

To add a new customer, click the "Add Customer" button. You will be redirected to a form to fill in the new customer's data. After filling in the details, click the "Save" button to save the customer to the database, and you will be redirected to the main list.
![image](https://github.com/Gagankashyap876287/Spring-boot/assets/121686792/344c7b30-abec-42c8-8529-9febe6f854b5)


### Updating an Customer

To update an customer, click the "Update" button next to the customer you want to edit. You will be directed to the update form where all fields will be pre-filled with the customer's data. Make any necessary changes and click "Save". You will then be redirected to the main list.
![image](https://github.com/Gagankashyap876287/Spring-boot/assets/121686792/759c5972-a22b-4183-ad7c-ce6a4d560ff6)


### Deleting an Customer

Clicking the "Delete" button will prompt a confirmation pop-up. If you confirm deletion, the customer will be removed from the database, and the list will be updated accordingly.
![image](https://github.com/Gagankashyap876287/Spring-boot/assets/121686792/2f5a79a8-78fb-4181-9cd0-7a9efad3f312)


### Pagination and Sorting
Where customer list is sorted and paginated.Also if you click on table headings customer list will get sorted according to the heading. 
![image](https://github.com/Gagankashyap876287/Spring-boot/assets/121686792/61b35bfd-4bb9-4dd2-99c1-c5038252fba4)

### Searching 
where you can search by firstname,city,email,phone.
![image](https://github.com/Gagankashyap876287/Spring-boot/assets/121686792/a066e040-c7db-4615-866c-8068a5237226)

### Login
where i have used spring security to login.You have to run the code where in the terminal you will get a password for login.





## Technologies Used

- Spring Boot
- Thymeleaf
- Spring Boot Web
- Spring Boot Devtools
- MySQL Connector




