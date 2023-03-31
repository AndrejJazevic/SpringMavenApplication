package com.maven.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Customer implements Serializable {
    public Customer() {}

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
    private String Firstname;

    public String getName() {
        return Firstname;
    }

    public void setName(String name) {
        Firstname = name;
    }

    @Basic(optional = false)
    @Column(nullable = false)
    private String Surname;

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    @Basic
    @Column(unique = true)
    private String Personal_code;

    public String getPersonal_code() {
        return Personal_code;
    }

    public void setPersonal_code(String personal_code) {
        Personal_code = personal_code;
    }

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
