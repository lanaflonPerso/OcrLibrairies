package com.users.controller.dto;

import com.users.technical.fieldmatch.FieldMatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@FieldMatch.List({
        @FieldMatch(first = "newPassword", second = "confirmPassword", message = "Les mots de passe doivent correspondre")
})
@Getter
@Setter
@NoArgsConstructor
public class UserPasswordUpdateDto {

    @NotEmpty(message = "Le mot de passe est obligatoire")
    private String oldPassword;

    @NotEmpty(message = "Le mot de passe est obligatoire")
    private String newPassword;


    @NotEmpty(message = "Le mot de passe est obligatoire")
    private String confirmPassword;
}
