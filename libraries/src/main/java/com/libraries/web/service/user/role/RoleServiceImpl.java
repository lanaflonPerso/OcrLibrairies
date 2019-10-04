package com.libraries.web.service.user.role;


import com.libraries.model.entity.Role;
import com.libraries.model.repository.user.IRoleRepository;
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

    @Value("${user.role}")
    private String role;

    /**
     * cherche un role utilisateur
     * @param id Id du role utilisateur à chercher
     * @return Le role utilisateur (entity)Role
     */
    public Role findRole(Long id) {
        return roleRepository.findRoleById( id );
    }

    /**
     * cherche un role utilisateur
     * @param name Nom du role utilisateur
     * @return Le role utilisateur (entity)Role
     */
    public Role findRole(String name) {
        return roleRepository.findRoleByName( name );
    }

    /**
     * Converti (entity) Role par defaut en ArraysList
     * @return ArraysList (entity) Role
     */
    public List<Role> findListRole(){
        return Arrays.asList( roleRepository.findRoleByName( this.role ) );
    }

    /**
     * Converti (entity) Role en ArraysList
     * @param id Id du role à convertir
     * @return ArraysList (entity) Role
     */
    public List<Role> findListRole(Long id){
        return Arrays.asList( roleRepository.findRoleById( id ) );
    }

    /**
     * Cherche un role
     * @param name Nom du role
     * @return ArraysList (entity) Role
     */
    public List<Role> findListRole(String name){
        return Arrays.asList( roleRepository.findRoleByName( name ) );
    }

}
