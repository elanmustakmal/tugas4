package com.elan.tugas4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
@Access(value=AccessType.FIELD)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String address;
    String country;
    String province;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JsonIgnore
    private User user;
//    @JoinColumn(name = "user_id", referencedColumnName = "id")

//    int User_Id;

//    @OneToOne(mappedBy = "user")
//@OneToOne(fetch = FetchType.LAZY, optional = false)
//@JoinColumn(name = "user_id", nullable = false)
//@JsonIgnore
//    User user;


    public Address() {
    }

    public Address(int id, String address, String country, String province, User user) {
        this.id = id;
        this.address = address;
        this.country = country;
        this.province = province;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
