package com.maven.repository;

import com.maven.entity.Customer;
import com.maven.entity.Item;
import com.maven.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class OrderRepositoryImpl implements OrderRepository{
    @PersistenceContext
    private EntityManager em;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ItemRepository itemRepository;

    public Order createOrder(Long id){
        Order order = new Order();
        List<Customer> selectAllCustomers = customerRepository.findAllCustomers();
        Customer customer = selectAllCustomers.get(1);
        order.setOrder_date(LocalDate.parse("2023-02-05"));
        order.getItems().add(itemRepository.findAllItems().get(0));

        customer.getOrders().add(order);
        order.setCustomer(customer);

        //em.persist(customer);
        em.persist(order);
        return order;
    }

    public Order getOrCreateOrder(Long id){
        Order order = em.find(Order.class, id);
        if (order == null){
            return createOrder(id);
        }
        return order;
    }

    public Order findOrderById(Long id){
        Order order = em.find(Order.class, id);
        return order;
    }

    public Order updateOrderCustomerById(Long orderId, Long customerId){
        Order order = em.find(Order.class, orderId);
        Customer customer = em.find(Customer.class, customerId);

        order.setCustomer(customer);
        em.merge(order);
        return order;
    }
    public Order deleteOrderById(Long id){
        Order order = em.find(Order.class, id);
        if(order != null){
            em.remove(order);
            return order;
        }
        return null;
    }
}
