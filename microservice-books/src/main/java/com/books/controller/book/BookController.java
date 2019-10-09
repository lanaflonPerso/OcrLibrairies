package com.books.controller.book;

import com.books.controller.dto.book.BookCreateDto;
import com.books.controller.dto.book.BookUpdateDto;
import com.books.exceptions.ResourceNotFoundException;
import com.books.model.book.Book;
import com.books.service.book.IBookService;
import com.books.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/all")
    public List<Book> bookList(){

        List<Book> bookList = bookService.findAll();
        if (bookList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return bookList;
    }

    @PostMapping
    public void newBook(@DTO(BookCreateDto.class) Book book) {
        bookService.save( book );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@DTO(BookUpdateDto.class) Book book ){
        bookService.save( book );
    }
}
