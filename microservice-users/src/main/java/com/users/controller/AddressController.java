package com.users.controller;

import com.users.controller.dto.address.AddressCreateDto;
import com.users.controller.dto.address.AddressUpdateDto;
import com.users.exceptions.ResourceNotFoundException;
import com.users.model.address.Address;
import com.users.service.address.IAddressService;
import com.users.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Address")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @GetMapping("/all")
    public List<Address> addressList(){

        List<Address> addressList = addressService.findAll();
        if (addressList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return addressList;
    }

    @PostMapping
    public void newAddress(@DTO(AddressCreateDto.class) Address address) {
        addressService.save( address );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAddress(@DTO(AddressUpdateDto.class) Address address ){
        addressService.save( address );
    }


}
