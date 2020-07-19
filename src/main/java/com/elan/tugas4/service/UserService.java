package com.elan.tugas4.service;

import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
