package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.CustomerRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
        customerRepository = theCustomerRepository;
    }

    // Method to retrieve all customers ordered by last name in ascending order
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllByOrderByLastNameAsc();
    }

    // Method to find a customer by ID
    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer theCustomer = null;

        if (result.isPresent()) {
            theCustomer = result.get();
        } else {
            // Throw exception if customer not found
            throw new RuntimeException("Did not find customer id - " + theId);
        }

        return theCustomer;
    }

    // Method to save a customer
    @Override
    public Customer save(Customer theEmployee) {
        return customerRepository.save(theEmployee);
    }

    // Method to delete a customer by ID
    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }

    // Method to find a paginated list of customers with sorting
    @Override
    public Page<Customer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.customerRepository.findAll(pageable);
    }

    // Method to list all customers based on a keyword
    @Override
    public List<Customer> listAll(String keyword) {
        if (keyword != null) {
            return customerRepository.search(keyword);
        } else {
            return (List<Customer>) customerRepository.findAllByOrderByLastNameAsc();
        }
    }
}
