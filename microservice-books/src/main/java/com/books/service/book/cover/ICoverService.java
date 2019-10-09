package com.books.service.book.cover;



import com.books.model.book.Cover;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICoverService {

    List<Cover> findAll();

    Cover save(String fileName, String contentType, byte[] data);
    Cover storeFile(MultipartFile file);
    Cover getFile(String fileId);
    Long getDataInterval();
}
