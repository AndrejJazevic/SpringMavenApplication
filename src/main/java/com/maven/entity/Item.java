package com.maven.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Item")
public class Item implements Serializable {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic(optional = false)
    @Column(nullable = false)
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Basic(optional = false)
    @Column(nullable = false)
    private Double Price;

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer Amount;

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    @ManyToMany(mappedBy = "items")
    private List<Order> orderitems;

    public List<Order> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Order> orderitems) {
        this.orderitems = orderitems;
    }
}
