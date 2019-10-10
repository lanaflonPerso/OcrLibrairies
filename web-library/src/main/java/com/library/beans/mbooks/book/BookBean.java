package com.library.beans.mbooks.book;

import com.library.beans.mbooks.lending.LendingBean;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public  @Data
class BookBean {

    private String isbn;

    private String title;

    private String summary;

    private Long review;

    private Long availability;

    private CoverBean cover;

    private List<LendingBean> lendingList;

    private LanguageBean language;

    private AuthorBean author;

    private ThemeBean theme;
}
