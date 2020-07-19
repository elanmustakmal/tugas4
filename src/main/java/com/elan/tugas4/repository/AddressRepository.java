package com.elan.tugas4.repository;

import com.elan.tugas4.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    Address findById(int id);
    Address findByAddress(String address);
}
