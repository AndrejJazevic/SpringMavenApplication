package com.maven;

//import com.maven.entity.Customer;
//import com.maven.entity.Customer;
//import com.maven.repository.CustomerRepositoryImpl;
//import com.maven.repository.ItemRepositoryImpl;
//import com.maven.repository.OrderRepositoryImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

//@SpringBootApplication
public class SpBootApp {
/*
    @Autowired
    private CustomerRepositoryImpl customerRepository;
    @Autowired
    private ItemRepositoryImpl itemRepository;
    @Autowired
    private OrderRepositoryImpl orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpBootApp.class, args);
    }

    @Override
    public void run(String... args){

      //  System.out.println(orderRepository.getOrCreateOrder(Long.valueOf(50)));

//        //Insert into Customer (*) values ("", "", "")
//        customerRepository.addCustomer("as", "esu", "9090");
//        customerRepository.addCustomer("as", "esu", "909023");
//        customerRepository.addCustomer("Labas", "esu", "909021");
//
//        //Select * from Customer
//        List<Customer> selectAllCustomers = customerRepository.findAllCustomers();
//        for(Customer customer:selectAllCustomers){
//            System.out.println(customer);
//        }
//
//        //Select id from Customer where firstname = ***
//        List<Long> getCustomerId1 = customerRepository.findCustomerIdByName("Labas");
//        for(Long id:getCustomerId1){
//            System.out.println(id);
//
//            //Update Customer set firstname = ***, lastname = ***
//            System.out.println("Updated: " + customerRepository.updateCustomerFirstnameAndLastnameById("as", "Labas", id));
//        }
//
//        //Select id from Customer where firstname = '***
//        List<Long> getCustomerId2 = customerRepository.findCustomerIdByName("as");
//        for(Long id:getCustomerId2){
//            System.out.println(id);
//
//            //Delete from Customer where Id = ***
//            System.out.println("Deleted: " + customerRepository.deleteCustomerById(id));
//        }

        System.out.println("Deleted: " + customerRepository.deleteCustomerById(3L));
    }
    /*
 */
}