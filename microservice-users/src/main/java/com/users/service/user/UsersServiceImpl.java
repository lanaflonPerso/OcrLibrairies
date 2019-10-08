package com.users.service.user;




import com.users.model.Users;
import com.users.repository.user.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Gestion des utilisateurs
 */
@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    /**
     * (Réservé à l'administreur)
     * On recherche la liste de tous les utilisateurs
     * @return La liste des utilisateurs
     */
    @Secured("ROLE_ADMIN")
    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    public void save( Users user){
        usersRepository.save( user );
    }




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}