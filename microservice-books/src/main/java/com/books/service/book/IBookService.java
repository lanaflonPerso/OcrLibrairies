package com.books.service.book;

import com.books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void  save(Book book);
}
