package com.books.service.book;

import com.books.model.book.Book;
import com.books.repository.book.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public void  save(Book book){
        bookRepository.save( book );
    }
}
