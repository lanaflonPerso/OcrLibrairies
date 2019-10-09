package com.library.beans.mbooks.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AuthorBean {
    private Long id;

    private String lastName;

    private String firstName;

    private List<BookBean> bookList;
}
