package com.books.service.book;

import com.books.model.book.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void  save(Book book);
}
