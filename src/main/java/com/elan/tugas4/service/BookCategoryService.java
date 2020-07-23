package com.elan.tugas4.service;


import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.Book;
import com.elan.tugas4.model.BookCategory;
import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.AddressRepository;
import com.elan.tugas4.repository.BookCategoryRepository;
import com.elan.tugas4.repository.BookRepository;
import com.elan.tugas4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookCategoryService {
    @Autowired
    BookRepository repo;

    @Autowired
    BookCategoryRepository bcrepo;

    public boolean deleteBookCategory(int id){
        BookCategory result = bcrepo.findById(id);
        if (result != null){
            try{
                bcrepo.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean updateBookCategory(BookCategory body){
        BookCategory result = bcrepo.findById(body.getId());
        if (result != null) {
            try {
                bcrepo.save(body);
                return true;
            } catch (Exception e){
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean addBookCategory(BookCategory body) {
        Book result;
        result = repo.findById(body.getId());
        Book book;
//        System.out.println("result" + result.toString());
        body.setBook(Collections.singleton(result));
        try{
            bcrepo.save(body);
//            System.out.println("bisa" + result.toString());
            return true;
        } catch (Exception e ) {
//            System.out.println("tidak bisa" + result.toString());
            return false;
        }

    }
//    public Book findByTitle(String title) {
//        Book result = repo.findByTitle(title);
//        return result;
//    }

//    public Book saveBody(Book book){
//        Book book1;
//        BookCategory bookCategory1 = book.getBookCategory();
//        try {
//            book.setBookCategory(null);
//            book1 = repo.save(book);
//            bookCategory1.setBook(book1);
//            bcrepo.save(bookCategory1);
//            System.out.println("input berhasil" + bookCategory1);
//            return book;
//        }catch (Exception e) {


//            return  book;
//        }
//
//    }

    }

