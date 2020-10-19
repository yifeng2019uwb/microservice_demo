package com.mia.customer.service;

import com.mia.customer.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getCustomers();
    String deleteCustomer(int id);
    Customer updateCustomer(Customer customer);

}
