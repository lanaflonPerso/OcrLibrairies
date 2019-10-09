package com.books.service.book.author;

import com.books.model.book.Author;
import com.books.repository.book.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private IAuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public void save(Author author){
        authorRepository.save( author );
    }
}
