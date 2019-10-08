package com.users.service.address.city;

import com.users.repository.address.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements ICityService  {

    @Autowired
    private ICityRepository cityRepository;

}
