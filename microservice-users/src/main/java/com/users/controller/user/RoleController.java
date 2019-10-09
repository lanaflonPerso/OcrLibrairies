package com.users.controller.user;


import com.users.exceptions.ResourceNotFoundException;

import com.users.model.user.Role;
import com.users.service.user.role.IRoleService;
import com.users.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping("/all")
    public List<Role> roleList(){

        List<Role> roleList = roleService.findAll();
        if (roleList.isEmpty()) throw new ResourceNotFoundException( "Aucun role trouvé");

        return roleList;
    }


}
