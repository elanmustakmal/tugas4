package com.elan.tugas4.model;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@Entity
@Table(name="book")
@Access(value= AccessType.FIELD)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @BatchSize(size = 20)
    private int id;

    private int price;

    private String publisher;

    private String title;

    private String writer;

    private int year;
    @ManyToOne(fetch = FetchType.EAGER)
//    @MapsId
//    @JsonIgnore
    @JoinColumn(name = "bookCategory", referencedColumnName = "id")
private BookCategory bookCategory;

    public Book() {
    }

    public Book(int id, int price, String publisher, String title, String writer, int year, BookCategory bookcategory) {
        this.id = id;
        this.price = price;
        this.publisher = publisher;
        this.title = title;
        this.writer = writer;
        this.year = year;
        this.bookCategory = bookcategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}
