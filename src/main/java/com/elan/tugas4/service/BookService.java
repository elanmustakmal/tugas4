package com.elan.tugas4.service;


import com.elan.tugas4.model.Book;
import com.elan.tugas4.model.BookCategory;
import com.elan.tugas4.repository.BookCategoryRepository;
import com.elan.tugas4.repository.BookRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

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

    public boolean saveBody(@NotNull Book book){
        try {
            repo.save(book);
             return true;
        }catch (Exception e) {
            return  false;
        }

    }

    }




