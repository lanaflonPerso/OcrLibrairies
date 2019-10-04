package com.libraries.service.user;


import com.libraries.model.Users;
import com.libraries.controller.dto.user.UserPasswordUpdateDto;
import com.libraries.controller.dto.user.UserRegistrationCreateDto;
import com.libraries.controller.dto.user.UserRegistrationUpdateDto;
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