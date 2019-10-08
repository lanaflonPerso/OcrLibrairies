package com.users.controller.dto.user;

import com.users.technical.fieldmatch.FieldMatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@FieldMatch.List({
        @FieldMatch(first = "email", second = "confirmEmail", message = "Les E-mails doivent correspondre")
})
@Getter
@Setter
@NoArgsConstructor
public class UserUpdateDto {

    @NotEmpty(message = "Le nom est obligatoire")
    private String nom;

    @NotEmpty(message = "Le prénom est obligatoire")
    private String prenom;

    @NotEmpty(message = "Le numéro de téléphone est obligatoire")
    private String telephone;

    @Email
    @NotEmpty(message = "L''adresse eMail est obligatoire")
    private String email;

    @Email
    @NotEmpty(message = "L''adresse eMail est obligatoire")
    private String confirmEmail;



}