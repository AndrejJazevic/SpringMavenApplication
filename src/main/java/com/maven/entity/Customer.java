package com.maven.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
    public Customer() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(unique = true)
    private String personal_code;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return firstname;
    }

    public void setName(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return lastname;
    }

    public void setSurname(String lastname) {
        this.lastname = lastname;
    }

    public String getPersonal_code() {
        return personal_code;
    }

    public void setPersonal_code(String personal_code) {
        this.personal_code = personal_code;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
