package com.maven.repository;

import com.maven.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAllCustomers();
    void addCustomer(String firstname, String lastname, String personal_code);
    Customer deleteCustomerById(Long id);
    List<Long> findCustomerIdByName(String firstname);
    Customer updateCustomerFirstnameAndLastnameById(String firstname, String lastname, Long id);
    Customer findCustomerById(Long id);
}
