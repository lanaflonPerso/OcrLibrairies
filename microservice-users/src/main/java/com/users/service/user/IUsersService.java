package com.users.service.user;



import com.users.controller.dto.user.UserPasswordUpdateDto;
import com.users.model.user.Users;

import java.util.List;


public interface IUsersService  {

    Users findUser(Long idUser);
    Users findUser(String email);

    List<Users> findAll();

    void save( Users user);

    void updateRole(Long idUser,String newRole);









}