package com.books.controller.dto.book.language;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class LanguageCreateDto {
    @NotEmpty(message = "Le nom de langue est obligatoire.")
    private String value;
}
