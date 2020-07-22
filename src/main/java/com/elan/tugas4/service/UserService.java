package com.elan.tugas4.service;

import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.AddressRepository;
import com.elan.tugas4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    @Autowired
    AddressRepository adrepo;

    @Autowired
    AddressService adservice;

    public boolean hapusUser(int id){
        User result = repo.findById(id);
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

    public boolean updateUser(User body){
        User result = repo.findById(body.getId());
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

    public User findByUsername(String username) {
        User result = repo.findByUsername(username);
        return result;
    }

    public User saveBody(User user){
        User user1;
        Address address1 = user.getAddress();
        try {
            user.setAddress(null);
            user1 = repo.save(user);
            address1.setUser(user1);
            adrepo.save(address1);
            System.out.println("input berhasil" + address1);
            return user;
        }catch (Exception e) {


            return  user;
        }

    }

    public List<Address> getAddress(String address) {
        Sort sortKey = Sort.by("address");
        return adrepo.findByAddress(address, sortKey);
    }

    public List<User> getAllUserByAddress(String search, String type) {
        switch (type) {
            case "city":
                return repo.findByAddress_CityContaining(search);
            case "province":
                return repo.findByAddress_ProvinceContaining(search);
            case "country":
                return repo.findByAddress_CountryContaining(search);
            default:
                return null;
        }
    }


}
