package com.elan.tugas4.repository;

import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends  JpaRepository<User, Integer > {
//    Page<User> findAll(Pageable pageable);
    User findByUsername(String username);
    User findById(int id);

    Page<User> findByUsernameContaining(String search, Pageable pageable);
    List<User> findByAddress_CityContaining(String search);
    List<User> findByAddress_ProvinceContaining(String search);
    List<User> findByAddress_CountryContaining(String search);
}
