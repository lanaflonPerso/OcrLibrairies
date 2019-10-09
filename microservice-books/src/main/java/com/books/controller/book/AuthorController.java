package com.books.controller.book;

import com.books.controller.dto.book.author.AuthorCreateDto;
import com.books.controller.dto.book.author.AuthorUpdateDto;
import com.books.exceptions.ResourceNotFoundException;
import com.books.model.book.Author;
import com.books.service.book.author.IAuthorService;
import com.books.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping("/all")
    public List<Author> authorList(){

        List<Author> authorList = authorService.findAll();
        if (authorList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return authorList;
    }

    @PostMapping
    public void newAuthor(@DTO(AuthorCreateDto.class) Author author) {
        authorService.save( author );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAuthor(@DTO(AuthorUpdateDto.class) Author author ){
        authorService.save( author );
    }
}
