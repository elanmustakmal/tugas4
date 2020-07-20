package com.elan.tugas4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="address")
@Access(value=AccessType.FIELD)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String address;
    private String country;
    private String province;
    private String city;
    private int postalcode;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JsonIgnore
    private User user;

    public Address() {
    }

    public Address(int id, String address, String country, String province, String city, int postalcode, User user) {
        this.id = id;
        this.address = address;
        this.country = country;
        this.province = province;
        this.city = city;
        this.postalcode = postalcode;
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
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

//    @Override
//    public String toString() {
//        return "Address{" +
//                "id=" + id +
//                ", address='" + address + '\'' +
//                ", country='" + country + '\'' +
//                ", province='" + province + '\'' +
//                ", city='" + city + '\'' +
//                ", postalcode=" + postalcode +
//                ", user=" + user +
//                '}';
//    }
}
