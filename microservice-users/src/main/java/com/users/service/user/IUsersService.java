package com.users.service.user;



import com.users.controller.dto.user.UserPasswordUpdateDto;
import com.users.model.user.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IUsersService extends UserDetailsService {

    List<Users> findAll();

    void save( Users user);
    void updateActive(Long idUser);
    void updatePassword( UserPasswordUpdateDto userPasswordUpdateDto);
    void updateRole(Long idUser,String newRole);

    Users findUser(Long idUser);
    Users findUser(String email);

    boolean isUserExisting(String email);
    boolean isUserConnected (Users userCompare);

    String currentUserNameSimple();
    String currentUserFirstName();
    String currentUserFullName();
    String currentUserPhone();
    String currentUserEmail();
    String currentUserProfil();
    Long currentUserId();

    boolean isAdmin();
    boolean isActuator();
    boolean isUser();
    boolean isCurrentUser(Long idUser);
    boolean isPasswordMatch(String pw);





}