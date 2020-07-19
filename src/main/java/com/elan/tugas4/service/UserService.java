package com.elan.tugas4.service;

import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.AddressRepository;
import com.elan.tugas4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

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

    @Autowired
    AddressRepository adrepo;
    public User saveBody(User user){
        User user1;
        Address address1 = user.getAddress();
        try {
            user.setAddress(address1);
            user1 = repo.save(user);
//            address1.setId(user1.getId());
            address1.setUser(user1);
            adrepo.save(address1);
            System.out.println("input berhasil" + address1);
            return user;
        }catch (Exception e) {


            return  user;
        }

    }

}
