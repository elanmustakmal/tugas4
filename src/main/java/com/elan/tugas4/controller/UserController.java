package com.elan.tugas4.controller;

import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.UserRepository;
import com.elan.tugas4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    UserRepository repo;
    @GetMapping("")
    List<User> getusers(){
        return repo.findAll();
    }

    @PostMapping("/insert")
    User insertUser(@RequestBody User body){
        User result = repo.save(body);
                return result;
    }

    @Autowired
    UserService service;
    @DeleteMapping("/delete")
    Map<String, Object> deleteUser (@RequestParam int id) {
        Map<String,Object> result = new HashMap<>();
        if (service.hapusUser(id)){
            result.put("Success", true);
        } else {
            result.put("Gagal", false);
        } return result;
    }

    @PutMapping("/update")
    Map<String, Object> updateUsers (@RequestBody User body){
        System.out.println("body : " + body.toString());
        Map<String,Object> result = new HashMap<>();


        if (service.updateUser(body)){
            result.put("succes",true);
            result.put("message","berhasil");
        } else {
            result.put("succes", false);
            result.put("message","gagal");
        }
        return result;
    }

    @GetMapping("getByUsername")
    User findByUsername(@RequestParam String username){
        User result = service.findByUsername(username);
        return result;
    }


    }



