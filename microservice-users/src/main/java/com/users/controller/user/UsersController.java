package com.users.controller.user;

import com.users.controller.dto.user.UserCreateDto;
import com.users.controller.dto.user.UserUpdateDto;
import com.users.exceptions.ResourceNotFoundException;
import com.users.model.user.Users;
import com.users.service.user.IUsersService;
import com.users.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @GetMapping("/all")
    public List<Users> usersList(){

        List<Users> usersList = usersService.findAll();
        if (usersList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return usersList;
    }

    @GetMapping(value = "/connection/{id}")
    public Users user(@PathVariable String  id){

        return usersService.findUser( id );

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