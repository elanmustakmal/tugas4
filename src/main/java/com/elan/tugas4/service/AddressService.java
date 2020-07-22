package com.elan.tugas4.service;

import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.AddressRepository;
import com.elan.tugas4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository adrepo;

    @Autowired
    UserRepository urepo;

    public boolean hapusAddress(int id){
        Address result = adrepo.findById(id);
        if (result != null){
            try{
                adrepo.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean updateAddress(Address body){
        Address result = adrepo.findById(body.getId());
        if (result != null) {
            try {
                adrepo.save(body);
                return true;
            } catch (Exception e){
                return false;
            }
        } else {
            return false;
        }
    }


    public boolean addAddress(Address body) {
        User userResult = urepo.findById(body.getId());
//        Address result = adrepo.save(body);

        System.out.println("result" + userResult.toString());

        if (userResult != null){
            body.setUser(userResult);
            try{
                adrepo.save(body);
                System.out.println("bisa" + userResult.toString());
                return true;
            } catch (Exception e ) {
                System.out.println("tidak bisa" + userResult.toString());
                return false;
            }
        } else {
            System.out.println("tidak bisa 2" + userResult.toString());
            return false;
        }
    }


}
