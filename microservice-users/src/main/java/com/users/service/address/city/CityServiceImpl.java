package com.users.service.address.city;

import com.users.model.address.City;
import com.users.repository.address.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService  {

    @Autowired
    private ICityRepository cityRepository;

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public void save(City city){
        cityRepository.save(city);
    }

}
