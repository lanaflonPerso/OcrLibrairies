package com.books.service.book.author;

import com.books.model.book.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findAll();
    void save(Author author);
}
