package com.books.controller.book;

import com.books.controller.dto.book.theme.ThemeCreateDto;
import com.books.controller.dto.book.theme.ThemeUpdateDto;
import com.books.exceptions.ResourceNotFoundException;
import com.books.model.book.Theme;
import com.books.service.book.theme.IThemeService;
import com.books.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Theme")
public class ThemeController {

    @Autowired
    private IThemeService themeService;

    @GetMapping("/all")
    public List<Theme> themeList(){

        List<Theme> themeList = themeService.findAll();
        if (themeList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return themeList;
    }

    @PostMapping
    public void newTheme(@DTO(ThemeCreateDto.class) Theme theme) {
        themeService.save( theme );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateTheme(@DTO(ThemeUpdateDto.class) Theme theme ){
        themeService.save( theme );
    }

}
