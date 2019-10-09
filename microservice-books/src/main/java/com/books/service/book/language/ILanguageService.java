package com.books.service.book.language;

import com.books.model.book.Language;

import java.util.List;

public interface ILanguageService {
    List<Language> findAll();
    void save (Language language);
}
