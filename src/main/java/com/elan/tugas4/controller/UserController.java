package com.elan.tugas4.controller;

import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.UserRepository;
import com.elan.tugas4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
public class UserController {


    @Autowired
    UserRepository repo;

    @GetMapping("")
    List<User> getusers(){
        return (List<User>) repo.findAll();
    }



    @PostMapping("insert")
    public User save(@RequestBody User user){
        return service.saveBody(user);
    }

    @Autowired
    UserService service;
    @DeleteMapping("delete")
    Map<String, Object> deleteUser (@RequestParam int id) {
        Map<String,Object> result = new HashMap<>();
        if (service.hapusUser(id)){
            result.put("Success", true);
        } else {
            result.put("Gagal", false);
        } return result;
    }

    @PutMapping("update")
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
        return service.findByUsername(username);

    }

    @RequestMapping (value = "page", method =  RequestMethod.GET)
    public Page<User> userPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }

//    @Autowired
//    UserService service1;
//    @RequestMapping("insertboth")
//    Map<String, Object> saveBody (@RequestParam User body) {
//        Map<String,Object> result = new HashMap<>();
//        if (service1.saveBody(body)){
//            result.put("Success", true);
//        } else {
//            result.put("Gagal", false);
//        } return result;
//    }


    }



