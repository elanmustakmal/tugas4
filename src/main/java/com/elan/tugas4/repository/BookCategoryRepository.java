package com.elan.tugas4.repository;


import com.elan.tugas4.model.Book;
import com.elan.tugas4.model.BookCategory;
import com.elan.tugas4.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {

    Page<BookCategory> findByNameContaining(String search, Pageable pageable);
    BookCategory findById(int id);
}
