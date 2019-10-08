package com.books.service.book.language;

import com.books.model.Language;
import com.books.repository.book.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements ILanguageService  {

    @Autowired
    private ILanguageRepository languageRepository;

    public List<Language> findAll(){
        return languageRepository.findAll();
    }

    public void save (Language language){
        languageRepository.save(language);
    }
}
