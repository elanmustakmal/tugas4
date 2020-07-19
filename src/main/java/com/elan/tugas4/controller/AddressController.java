package com.elan.tugas4.controller;


import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.AddressRepository;
import com.elan.tugas4.repository.UserRepository;
import com.elan.tugas4.service.AddressService;
import com.elan.tugas4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/address")
public class AddressController {


    @Autowired
    AddressRepository adrepo;

    @GetMapping("")
    List<Address> getAddress(){
        return adrepo.findAll();
    }

    @PostMapping("/insert")
    Address insertAddress (@RequestBody Address body){
        Address result = adrepo.save(body);
        return result;
    }

    @Autowired
    AddressService adservice;
    @DeleteMapping("/delete")
    Map<String, Object> deleteAddress (@RequestParam int id) {
        Map<String,Object> result = new HashMap<>();
        if (adservice.hapusAddress(id)){
            result.put("Success", true);
        } else {
            result.put("Gagal", false);
        } return result;
    }

    @PutMapping("/update")
    Map<String, Object> updateAddress (@RequestBody Address body){
        System.out.println("body : " + body.toString());
        Map<String,Object> result = new HashMap<>();


        if (adservice.updateAddress(body)){
            result.put("succes",true);
            result.put("message","berhasil");
        } else {
            result.put("succes", false);
            result.put("message","gagal");
        }
        return result;
    }

    @GetMapping("getByAddress")
    Address findByAddress(@RequestParam String address){
        Address result = adservice.findByAddress(address);
        return result;
    }

}
