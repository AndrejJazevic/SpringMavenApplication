package com.maven;

import com.maven.entity.Customer;
import com.maven.repository.CustomerRepository;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
public class SpBootApp implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpBootApp.class, args);
    }

    @Override
    public void run(String... args){

        //Insert into Customer (*) values ("", "", "")
        customerRepository.addCustomer("as", "esu", "9090");
        customerRepository.addCustomer("as", "esu", "909023");
        customerRepository.addCustomer("Labas", "esu", "909021");

        //Select * from Customer
        List<Customer> selectAllCustomers = customerRepository.findAllCustomers();
        for(int i = 0; i < selectAllCustomers.toArray().length; i++){
            System.out.println(selectAllCustomers.get(i));
        }

        //Select id from Customer where firstname = ***
        List<Long> getCustomerId1 = customerRepository.findCustomerIdByName("Labas");
        for(int i = 0; i < getCustomerId1.toArray().length; i++){
            System.out.println(getCustomerId1.get(i));

            //Update Customer set firstname = ***, lastname = ***
            System.out.println("Updated: " + customerRepository.updateCustomerFirstnameAndLastnameById("as", "Labas", getCustomerId1.get(i)));
        }

        //Select id from Customer where firstname = '***
        List<Long> getCustomerId2 = customerRepository.findCustomerIdByName("as");
        for(int i = 0; i < getCustomerId2.toArray().length; i++){
            System.out.println(getCustomerId2.get(i));

            //Delete from Customer where Id = ***
            System.out.println("Deleted: " + customerRepository.deleteCustomerById(getCustomerId2.get(i)));
        }
    }
}