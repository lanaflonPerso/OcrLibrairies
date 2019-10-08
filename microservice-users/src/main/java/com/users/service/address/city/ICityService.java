package com.users.service.address.city;

import com.users.model.address.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();
    void save(City city);
}
