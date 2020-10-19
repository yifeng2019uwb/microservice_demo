package com.mia.customer.controller;


import com.mia.customer.entity.Customer;
import com.mia.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public Customer addProduct(@RequestBody Customer customer) {

        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customer")
    public List<Customer> findAllProducts() {
        return customerService.getCustomers();
    }

    @GetMapping("/customerById/{id}")
    public Customer findProductById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }


}
