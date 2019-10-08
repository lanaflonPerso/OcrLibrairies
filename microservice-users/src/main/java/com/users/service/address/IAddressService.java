package com.users.service.address;

import com.users.model.address.Address;

import java.util.List;

public interface IAddressService {
    List<Address> findAll();
    void save(Address address);
}
