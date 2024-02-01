package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

// Service interface for Customer entity
public interface CustomerService {

    // Method to retrieve all customers
    List<Customer> findAll();

    // Method to find a customer by ID
    Customer findById(int theId);

    // Method to save a customer
    Customer save(Customer theCustomer);

    // Method to delete a customer by ID
    void deleteById(int theId);

    // Method to find a paginated list of customers with sorting
    Page<Customer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    // Method to list all customers based on a keyword
    List<Customer> listAll(String keyword);
}
