package com.users.service.user.role;



import com.users.model.user.Role;
import com.users.repository.user.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Gestion des roles utilisateur
 */
@Service
public class RoleServiceImpl implements IRoleService {


    @Autowired
    IRoleRepository roleRepository;

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public void save(Role role){
        roleRepository.save( role );
    }



}
