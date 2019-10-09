package com.library.beans.mbooks.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ThemeBean {

    private Long id;

    private String value;

    private List<BookBean> bookList;
}
