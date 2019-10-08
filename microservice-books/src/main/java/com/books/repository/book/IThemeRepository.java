package com.books.repository.book;

import com.books.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IThemeRepository extends JpaRepository<Theme,Long> {
}
