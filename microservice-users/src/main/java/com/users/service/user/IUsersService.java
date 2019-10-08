package com.users.service.user;



import com.users.model.user.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IUsersService extends UserDetailsService {

    List<Users> findAll();
    void save( Users user);


}