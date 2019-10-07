package com.mbooks.service.photo;


import com.libraries.model.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPhotoService {

    List<Photo> findAll();

    Photo save(String fileName, String contentType, byte[] data);
    Photo storeFile(MultipartFile file);
    Photo getFile(String fileId);
    Long getDataInterval();
}
