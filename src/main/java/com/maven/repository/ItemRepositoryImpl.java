package com.maven.repository;

import com.maven.entity.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

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
}
