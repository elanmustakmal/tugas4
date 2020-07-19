package com.elan.tugas4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="user")
@Access(value=AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String username;
    @JsonIgnore
    String password;

    String name;

    String role;

    String email;
    boolean active;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")


    public User() {
    }

    public User(int id, String username, String password, String name, String role, String email, boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.email = email;
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
