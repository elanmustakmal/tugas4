package com.elan.tugas4.repository;

import com.elan.tugas4.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String >, PagingAndSortingRepository<User, String> {
    Page<User> findAll(Pageable pageable);
    User findById(int id);
    User findByUsername(String username);

//    List<User> findAllById(int id, Pageable pageable);
}
