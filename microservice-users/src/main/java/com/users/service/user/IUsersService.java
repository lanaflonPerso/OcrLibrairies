package com.users.service.user;


import com.users.controller.dto.UserPasswordUpdateDto;
import com.users.controller.dto.UserRegistrationCreateDto;
import com.users.controller.dto.UserRegistrationUpdateDto;
import com.users.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUsersService extends UserDetailsService {

    boolean isAdmin();
    boolean isActuator();
    boolean isUser();

    List<Users> findAll();
    Users findByEmail(String email);
    Users findUser(Long idUser);

    void updateActive(Long idUser);
    void updateRole(Long idUser, String newRole);

    Users findCurrentUserDetail();
    String currentUserPrenom();
    String currentUserNom();
    String currentUserTelephone();
    String currentUserEmail();
    String currentUserProfil();
    Long currentUserId();
    boolean isPasswordMatch(String pw);

    void save(UserRegistrationUpdateDto userRegistrationUpdateDto);
    void save(UserPasswordUpdateDto userPasswordUpdateDto);

    UserRegistrationUpdateDto userRegistrationUpdateDto();


    boolean isAuthorCreate(Users authorCreate);
    boolean isCurrentUser(Long idUser);

    boolean isUserExisting(String email);


    Users save(UserRegistrationCreateDto registration);
    String currentUserNameSimple();

}