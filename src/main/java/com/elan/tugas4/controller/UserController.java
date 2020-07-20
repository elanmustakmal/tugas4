package com.elan.tugas4.controller;

import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.UserRepository;
import com.elan.tugas4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user/")
public class UserController {


    @Autowired
    UserRepository repo;

    @GetMapping("")
    List<User> getusers() {
        return (List<User>) repo.findAll();
    }


    @PostMapping("insert")
    public User save(@RequestBody User user) {
        return service.saveBody(user);
    }

    @Autowired
    UserService service;

    @DeleteMapping("delete")
    Map<String, Object> deleteUser(@RequestParam int id) {
        Map<String, Object> result = new HashMap<>();
        if (service.hapusUser(id)) {
            result.put("Success", true);
        } else {
            result.put("Gagal", false);
        }
        return result;
    }

    @PutMapping("update")
    Map<String, Object> updateUsers(@RequestBody User body) {
        System.out.println("body : " + body.toString());
        Map<String, Object> result = new HashMap<>();


        if (service.updateUser(body)) {
            result.put("succes", true);
            result.put("message", "berhasil");
        } else {
            result.put("succes", false);
            result.put("message", "gagal");
        }
        return result;
    }

    @GetMapping("getByUsername")
    User findByUsername(@RequestParam String username) {
        return service.findByUsername(username);

    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @GetMapping("page")
    public ResponseEntity<Map<String, Object>> getAllUsers(
            @RequestParam(required = false) String username,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<User> user = new ArrayList<User>();
            Pageable paging = PageRequest.of(page, size);

            Page<User> pageuser;
            if (username == null) {
                pageuser = repo.findAll(paging);
            }  else {
                pageuser = repo.findByUsernameContaining(username, paging);
            }

            user = pageuser.getContent();

            if (user.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            } else {

                Map<String, Object> result = new HashMap<>();
                result.put("user", user);
                result.put("currentPage", pageuser.getNumber());
                result.put("totalItems", pageuser.getTotalElements());
                result.put("totalPages", pageuser.getTotalPages());


                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @GetMapping("byAddress")
//    public List<Address> getbyAddress(@PathVariable String address){
//        return service.getAddress(address);
//    }

//    @GetMapping("page")
//    public List<User> getAllUser(@RequestParam(defaultValue = "0") Integer page,
//                                 @RequestParam(defaultValue = "address") String sortKey) {
//        return service.getAllUser(page, sortKey);
//    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @GetMapping("byAddress")
    public ResponseEntity<Map<String, Object>> getByAddress(
            @RequestParam String search,
            @RequestParam String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<User> user;
            Pageable paging = PageRequest.of(page, size);

            Page<User> pageuser;
            if (search.isEmpty()) {
                pageuser = repo.findAll(paging);
            }  else {
                Map<String, Object> result = new HashMap<>();
                result.put("all user address" , service.getAllUserByAddress(search, type));

                return new ResponseEntity<>(result, HttpStatus.OK);

            }

            user = pageuser.getContent();

            if (user.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            } else {

                Map<String, Object> response1 = new HashMap<>();
                response1.put("user", user);
                response1.put("currentPage", pageuser.getNumber());
                response1.put("totalItems", pageuser.getTotalElements());
                response1.put("totalPages", pageuser.getTotalPages());


                return new ResponseEntity<>(response1, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}



