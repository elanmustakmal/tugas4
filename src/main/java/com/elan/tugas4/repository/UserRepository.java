package com.elan.tugas4.repository;

import com.elan.tugas4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String > {
    User findById(int id);
    User findByUsername(String username);
}