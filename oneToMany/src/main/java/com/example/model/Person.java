package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "per")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "perid")
    private Long per_id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    public Person() {
    }

    public Person( String name, String password) {
        
        this.name = name;
        this.password = password;
    }

    public Long getPer_id() {
        return per_id;
    }

    public void setPer_id(Long per_id) {
        this.per_id = per_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person [per_id=" + per_id + ", name=" + name + ", password=" + password + "]";
    }

    
    //  @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name ="address_id")
    // private Address address;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "empid", referencedColumnName = "empid")
    private List<Address> address;
}
