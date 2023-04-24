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

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{
    @PersistenceContext
    private EntityManager em;

    public List<Customer> findAllCustomers(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);

        Root<Customer> root = query.from(Customer.class);
        query.select(root);

        TypedQuery<Customer> q = em.createQuery(query);
        List<Customer> resultList = q.getResultList();
        return resultList;
    }

    public void addCustomer(String firstname, String lastname, String personal_code) {
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setPersonal_code(personal_code);
        em.persist(customer);
    }

    public Customer deleteCustomerById(Long id){
        Customer customer = em.find(Customer.class, id);
        if(customer != null){
            em.remove(customer);
            return customer;
        }
        return null;
    }

    public List<Long> findCustomerIdByName(String firstname){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);

        Root<Customer> root = query.from(Customer.class);
        Predicate predicate = cb.equal(root.get(Customer_.firstname), firstname);
        query.where(predicate);
        query.select(root.get(Customer_.id));

        TypedQuery<Long> q = em.createQuery(query);
        List<Long> resultList = q.getResultList();
        return resultList;
    }

    public Customer updateCustomerFirstnameAndLastnameById(String firstname, String lastname, Long id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);

        Root<Customer> root = query.from(Customer.class);
        Predicate predicate = cb.equal(root.get(Customer_.id), id);
        query.where(predicate);
        query.select(root);

        TypedQuery<Customer> q = em.createQuery(query);
        Customer resultList = q.getSingleResult();
        resultList.setFirstname(firstname);
        resultList.setLastname(lastname);
        em.merge(resultList);
        return resultList;
    }
    public Customer findCustomerById(Long id){
        Customer customer = em.find(Customer.class, id);
        return customer;
    }
    public Customer findAllCustomersByItemId(Long id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Item item = em.find(Item.class, id);

        Root<Order> root = query.from(Order.class);

        Predicate predicate = cb.equal(root.get(Order_.items), item);
        query.where(predicate);
        query.select(root.get(Order_.id));

        TypedQuery<Long> q = em.createQuery(query);
        List<Long> resultList = q.getResultList();
        System.out.println(resultList);
        return null;
    }
    public Customer updateCustomerId(Long oldId, Long newId){
        Customer customer = em.find(Customer.class, oldId);
        customer.setId(newId);
        em.merge(customer);
        return customer;
    }
}
