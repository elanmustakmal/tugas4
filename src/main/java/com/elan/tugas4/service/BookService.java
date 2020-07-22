package com.elan.tugas4.service;


import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.Book;
import com.elan.tugas4.model.BookCategory;
import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.AddressRepository;
import com.elan.tugas4.repository.BookCategoryRepository;
import com.elan.tugas4.repository.BookRepository;
import com.elan.tugas4.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository repo;

    @Autowired
    BookCategoryRepository bcrepo;

    @Autowired
    AddressService adservice;

    public boolean deleteBook(int id){
        Book result = repo.findById(id);
        if (result != null){
            try{
                repo.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean updateBook(Book body){
        Book result = repo.findById(body.getId());
        if (result != null) {
            try {
                repo.save(body);
                return true;
            } catch (Exception e){
                return false;
            }
        } else {
            return false;
        }
    }

    public Book findByTitle(String title) {
        Book result = repo.findByTitle(title);
        return result;
    }

    public BookCategory findByCategory(int id) {
        BookCategory result = bcrepo.findById(id);
        return result;
    }

    public boolean saveBody(Book book){
        Book book1;
        BookCategory bookCategory1 = book.getBookcategory();
        try {
            book.setBookcategory(bookCategory1);
            book1 = repo.save(book);
            bookCategory1.setBook(Collections.singleton(book1));
            bcrepo.save(bookCategory1);
            System.out.println("input berhasil" + bookCategory1);
            return true;
        }catch (Exception e) {
            return  false;
        }

    }

//    public List<Address> getAddress(String address) {
//        Sort sortKey = Sort.by("address");
//        return adrepo.findByAddress(address, sortKey);
//    }

//    public List<User> getAllUserByAddress(String search, String type) {
//        switch (type) {
//            case "city":
//                return repo.findByAddress_CityContaining(search);
//            case "province":
//                return repo.findByAddress_ProvinceContaining(search);
//            case "country":
//                return repo.findByAddress_CountryContaining(search);
//            default:
//                return null;
//        }
    }




