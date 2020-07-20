package com.elan.tugas4.controller;


import com.elan.tugas4.model.Address;
import com.elan.tugas4.repository.AddressRepository;
import com.elan.tugas4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/address/")
public class AddressController {

    @Autowired
    AddressService adservice;
    @Autowired
    AddressRepository adrepo;

    @GetMapping("")
    List<Address> getAddress(){
        return adrepo.findAll();
    }

    @PostMapping("insert")
    Map insertAddress (@RequestBody Address body){

            Map<String,Object> result = new HashMap<>();

            System.out.println("body " + body.toString());
            boolean status = adservice.addAddress(body);
            if (status){
                result.put("succes",true);
                result.put("message","berhasil");
            }else{
                result.put("success",false);
                result.put("message","gagal");
            }

       return result;
    }


    @DeleteMapping("delete")
    Map<String, Object> deleteAddress (@RequestParam int id) {
        Map<String,Object> result = new HashMap<>();
        if (adservice.hapusAddress(id)){
            result.put("Success", true);
        } else {
            result.put("Gagal", false);
        } return result;
    }

    @PutMapping("update")
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




}
