package com.elan.tugas4.service;

import com.elan.tugas4.model.Address;
import com.elan.tugas4.model.User;
import com.elan.tugas4.repository.AddressRepository;
import com.elan.tugas4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository adrepo;

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

    public Address findByAddress(String address) {
        Address result = adrepo.findByAddress(address);
        return result;
    }
}
