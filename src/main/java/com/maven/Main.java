package com.maven;

import com.maven.entity.Customer;
import com.maven.repository.CustomerRepository;
import com.maven.repository.CustomerRepositoryImpl;
import com.maven.repository.ItemRepository;
import com.maven.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


@EnableTransactionManagement
@Component
public class Main {
    private static AnnotationConfigApplicationContext ctx;

    public static void main(String[] args) {

        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Hello");

        OrderRepository orderRepository = ctx.getBean(OrderRepository.class);
        CustomerRepository customerRepository = ctx.getBean(CustomerRepository.class);
        ItemRepository itemRepository = ctx.getBean(ItemRepository.class);

        System.out.println(itemRepository.findAllAddedItemsByCustomerId(1L));
        //System.out.println(customerRepository.findAllCustomersByItemId(1L));
        //System.out.println(orderRepository.getOrCreateOrder(Long.valueOf(50)));
        //System.out.println(orderRepository.deleteOrderById(9L));
        //System.out.println(customerRepository.updateCustomerId(5L, 6L));
//
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
//
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
//
//        System.out.println("Deleted: " + customerRepository.deleteCustomerById(3L));
    }
}