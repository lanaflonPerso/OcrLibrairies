package com.books.controller.book;

import com.books.config.ApplicationPropertiesConfig;
import com.books.controller.dto.book.language.LanguageCreateDto;
import com.books.controller.dto.book.language.LanguageUpdateDto;
import com.books.exceptions.ResourceNotFoundException;
import com.books.model.book.Language;
import com.books.service.book.language.ILanguageService;
import com.books.technical.dto.DTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Language")
public class LanguageController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ILanguageService languageService;


    @GetMapping("/all")
    public List<Language> languageList(){

        List<Language> addressList = languageService.findAll();
        if (addressList.isEmpty()) throw new ResourceNotFoundException( "Aucun langage trouvé");

        log.info("Récupération de la liste des langues");
        return addressList;
    }

    @PostMapping
    public void newLanguage(@DTO(LanguageCreateDto.class) Language language) {
        languageService.save( language );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateLanguage(@DTO(LanguageUpdateDto.class) Language language ){
        languageService.save( language );
    }
}
