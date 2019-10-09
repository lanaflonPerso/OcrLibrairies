package com.books.repository.book;

import com.books.model.book.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageRepository extends JpaRepository<Language,Long> {
}
