package com.books.repository.book;

import com.books.model.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
