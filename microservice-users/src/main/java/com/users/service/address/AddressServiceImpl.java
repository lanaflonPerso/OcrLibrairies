package com.users.service.address;

import com.users.model.address.Address;
import com.users.repository.address.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public void save(Address address){
        addressRepository.save(address);
    }
}
