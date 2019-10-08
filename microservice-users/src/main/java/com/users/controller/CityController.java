package com.users.controller;

import com.users.service.address.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/City")
public class CityController {

    @Autowired
    private ICityService cityService;





}
