package com.users.controller;



import com.users.controller.dto.UserPasswordUpdateDto;
import com.users.controller.dto.UserRegistrationCreateDto;
import com.users.controller.dto.UserRegistrationUpdateDto;
import com.users.model.Users;
import com.users.service.user.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private IUsersService usersService;

    @ModelAttribute
    public IUsersService userService(){return usersService;}




    @ModelAttribute("user")
    public UserRegistrationCreateDto userRegistrationDto() {

        return new UserRegistrationCreateDto(  );
    }

    @ModelAttribute
    public UserPasswordUpdateDto userPasswordUpdateDto(){return new UserPasswordUpdateDto();}

    @Secured("ROLE_ADMIN")
    @GetMapping("/all")
    public String list(Model model){
        return "user/all-user";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/updateActive/{idUser}")
    public String updateActive(@PathVariable("idUser") Long idUser, Model model){

        if( !usersService.isCurrentUser( idUser ) )
            usersService.updateActive( idUser );

        return "user/all-user";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/updateRole/{idUser}/{role}")
    public String updateRole(@PathVariable("idUser") Long idUser,@PathVariable("role")String role, Model model){

        if( !usersService.isCurrentUser( idUser ) )
            usersService.updateRole(idUser, role );

        return "user/all-user";
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "user/registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationCreateDto userDto,
                                      BindingResult result) {

        Users existing = usersService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "Il y a déjà un compte enregistré avec cet email");
        }

        if (result.hasErrors()) {
            return "user/registration";
        }

        usersService.save(userDto);
        return "redirect:registration?success";
    }

    @GetMapping("/info")
    public String info(Model model){return "user/info-user"; }

    @GetMapping("/edit")
    public String edit(Model model){

        UserRegistrationUpdateDto userRegistrationUpdateDto = usersService.userRegistrationUpdateDto();
        model.addAttribute( userRegistrationUpdateDto );
        return "user/update-user";
    }

    @PostMapping("/update")
    public String update( @Valid UserRegistrationUpdateDto userDto, BindingResult result){

        if (!usersService.isUserExisting( userDto.getEmail() ) ) {
            result.rejectValue("email", null, "Il y a déjà un compte enregistré avec cet email");
        }

        if (result.hasErrors()) {
            return "user/update-user";
        }

        usersService.save( userDto );
        return "redirect:/registration/info";
    }

    @GetMapping("/password/edit")
    public String passwordEdit(Model model){
        return "user/update-password-user";
    }

    @PostMapping("/password/update")
    public String passwordUpdate(  @Valid UserPasswordUpdateDto userDto, BindingResult result){

        if(! usersService.isPasswordMatch( userDto.getOldPassword() ) )
            result.rejectValue("oldPassword", null, "mot de passe erroné");

        if (result.hasErrors())
            return "user/update-password-user";

        usersService.save( userDto );
        return "redirect:/registration/password/edit?success";
    }
}