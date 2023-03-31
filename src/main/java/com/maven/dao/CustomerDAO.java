package com.maven.dao;

import com.maven.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerDAO {
    private final EntityManager em;
    //private CustomerDAO(){}
    public List<Customer> getAllCustomers(String name, String surname, String personal_code){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);

        //select * from Customer
        Root<Customer> root = criteriaQuery.from(Customer.class);

        //where name like '%%'
        Predicate predicate = criteriaBuilder.like(root.get("Name"), "%" + name + "%");

        //select * from Customer where name like '%%'
        criteriaQuery.where(predicate);

        TypedQuery<Customer> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
