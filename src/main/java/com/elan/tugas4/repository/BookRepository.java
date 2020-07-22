package com.elan.tugas4.repository;

import com.elan.tugas4.model.Book;
import com.elan.tugas4.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByTitle(String title);
    Book findById(int id);

    Page<Book> findByTitleContaining(String search, Pageable pageable);
//    List<Book> findByCategoryContaining(String search);

}
