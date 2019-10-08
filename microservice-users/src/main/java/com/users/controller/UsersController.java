package com.users.controller;



import com.users.controller.dto.user.UserPasswordUpdateDto;
import com.users.controller.dto.user.UserCreateDto;
import com.users.controller.dto.user.UserUpdateDto;
import com.users.exceptions.ResourceNotFoundException;
import com.users.model.Users;
import com.users.service.user.IUsersService;
import com.users.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("User")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @GetMapping("/all")
    public List<Users> usersList(){

        List<Users> usersList = usersService.findAll();
        if (usersList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return usersList;
    }

    @PostMapping
    public void newUser(@DTO(UserCreateDto.class) Users user) {
        usersService.save( user );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@DTO(UserUpdateDto.class) Users user ){
        usersService.save( user );
    }



}