package com.maven.dao;

import com.maven.entity.*;
import com.maven.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerDAO {
    private final EntityManager em;

    public CustomerDAO(EntityManager em) {
        this.em = em;
    }
/*
    public List<Customer> getAllCustomers(String name, String surname, String personal_code){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);

        //select * from Customer
        Root<Customer> root = criteriaQuery.from(Customer.class);


        Path<String> pathName = root.get("Name");
        Path<Object> pathLName = root.get("LName");


        //where name like '%%'
        Predicate predicate = criteriaBuilder.like(root.get("Name"), "%" + name + "%");

        //select * from Customer where name like '%%'
        criteriaQuery.where(predicate);
        criteriaQuery.select(criteriaBuilder.tuple(pathName,pathLName));

        TypedQuery<Tuple> query = em.createQuery(criteriaQuery);

        List<Tuple> resultList = query.getResultList();


        resultList.forEach(tuple ->{
            String name = tuple.get(pathName);
        });



        return null;
    }

    public List<Item> getAllItemsForCustomer(String name){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> query = cb.createQuery(Item.class);
        Root<Customer> root = query.from(Customer.class);


        //Predicate firstname = cb.like(root.get("firstname"), name);
        Predicate firstname = cb.like(root.get(Customer_.firstName), name);

        Join<Customer, Order> orders = root.join(Customer_.orders);
        Join<Order, Item> item = orders.join("item");
        query.where(firstname);



select * from item where item.id in
    (select item_id from Order_items where order in
        (select order.id from orders where order.customer in
            (select id customer where firstname like 'jonas')
        )
    )


        TypedQuery<Item> query = em.createQuery(query);

        List<Tuple> resultList = query.getResultList();


        resultList.forEach(tuple ->{
            String name = tuple.get(pathName);
        });



        return null;
    }


 */


    public void addItems(EntityManager em, List<Item> items){
        for(Item item:items){
            em.persist(item);//kada item yra naujai sukurtas (dar be ID)
            em.merge(item);//kada item yra nenaujas, tikriausiai pakeistas (su ID)
            em.contains(item);
            // kada item yra entitymanager cache, bet nebūtinai bazėje
            // pvz. po delete arba po perssite bet dar prieš commit
            em.detach(item);

            em.createQuery("select * from dual").getResultList();
        }

    }
}
