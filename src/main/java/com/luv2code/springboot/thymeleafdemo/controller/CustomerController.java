package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;
import com.luv2code.springboot.thymeleafdemo.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    // Constructor Injection for CustomerService
    public CustomerController(CustomerService theCustomerService) {
        customerService = theCustomerService;
    }

    // Mapping for homepage with search functionality
    @GetMapping("/")
    public String viewHomePage1(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<Customer> listCustomer;
        if (keyword != null && !keyword.isEmpty()) {
            listCustomer = customerService.listAll(keyword);
        } else {
            listCustomer = customerService.findAll();
        }

        model.addAttribute("customers", listCustomer);
        model.addAttribute("keyword", keyword);
        return "customers/list-customers";
    }

    // Mapping to list all customers
    @GetMapping("/list")
    public String listCustomer(Model theModel) {
        // Redirect to paginated list with default parameters
        return findPaginated(1, "firstName", "asc", theModel);
    }

    // Mapping to display all customers without pagination
    @GetMapping("/search")
    public String getCustomer(Model theModel) {
        List<Customer> theCustomers = customerService.findAll();
        theModel.addAttribute("customers", theCustomers);
        return "customers/list-customers";
    }

    // Mapping to show form for adding a new customer
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customers/customer-form";
    }

    // Mapping to show form for updating an existing customer
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
        Customer theCustomer = customerService.findById(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customers/customer-form";
    }

    // Mapping to save a customer
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.save(theCustomer);
        return "redirect:/customers/list";
    }

    // Mapping to delete a customer
    @GetMapping("/delete/{customerId}")
    public String delete(@PathVariable("customerId") int theId) {
        customerService.deleteById(theId);
        return "redirect:/customers/list";
    }

    // Mapping to find paginated list of customers
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;

        // Retrieve paginated data from service
        Page<Customer> page = customerService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Customer> listCustomers = page.getContent();

        // Add pagination attributes to model
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("customers", listCustomers);

        return "customers/list-customers";
    }
}
