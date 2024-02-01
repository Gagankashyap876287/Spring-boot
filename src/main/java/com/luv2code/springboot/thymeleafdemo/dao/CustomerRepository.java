package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Repository interface for Customer entity
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Method to find all customers ordered by last name in ascending order
    public List<Customer> findAllByOrderByLastNameAsc();

    // Custom query to search for customers based on keyword matching first name, city, email, or phone
    @Query("SELECT customer FROM Customer customer WHERE CONCAT(customer.firstName, ' ', customer.city, ' ', customer.email, ' ', customer.phone) LIKE %?1%")
    public List<Customer> search(String keyword);
}
