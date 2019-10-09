package com.books.service.book.theme;


import com.books.model.book.Theme;

import java.util.List;

public interface IThemeService {
    List<Theme> findAll();
    void save(Theme theme);
}

