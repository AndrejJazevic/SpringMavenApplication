package com.maven.repository;

import com.maven.entity.Customer;
import com.maven.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository{
    @PersistenceContext
    private EntityManager em;
    @Autowired
    CustomerRepositoryImpl customerRepository;

    public Order createOrder(Long id){
        Order order = new Order();
        List<Customer> selectAllCustomers = customerRepository.findAllCustomers();
        order.setId(id);
        //order.setOrder_date(LocalDate.parse("2023-02-02"));
        order.setCustomer(selectAllCustomers.get(0));
//        em.persist(order);
        return order;
    }

    public Order getOrCreateOrder(Long id){
        Order order = em.find(Order.class, id);
        if (order == null){
            return createOrder(id);
        }
        return order;
    }
}
