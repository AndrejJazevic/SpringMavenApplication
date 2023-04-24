package com.maven.repository;

import com.maven.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class ItemRepositoryImpl implements ItemRepository{
    @PersistenceContext
    private EntityManager em;

    public List<Item> findAllItems(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> query = cb.createQuery(Item.class);

        Root<Item> root = query.from(Item.class);
        query.select(root);

        TypedQuery<Item> q = em.createQuery(query);
        List<Item> resultList = q.getResultList();
        return resultList;
    }

    public List<Item> findAllAddedItemsByCustomerId(Long id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Customer customer = em.find(Customer.class, id);

        Root<Order> root = query.from(Order.class);

        Predicate predicate = cb.equal(root.get(Order_.customer), customer);
        query.where(predicate);
        query.select(root.get(Order_.id));

        // select * from item where id in(
        // select item_id from order_items where order_id in(
        // select id from order join customer on order.customer_id == customer.id where order.customer_id=={customer.id}))

        TypedQuery<Long> q = em.createQuery(query);
        List<Long> resultList = q.getResultList();
        for(Long orderid:resultList) {
            Order order = em.find(Order.class, orderid);
            System.out.println(order.getItems());
        }
        return null;
    }
}
