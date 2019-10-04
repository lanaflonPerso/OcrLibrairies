package com.libraries.repository.photo;



import com.libraries.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JPA Initialisation de l'entity Photo
 */
@Repository
public interface IPhotoRepository extends JpaRepository<Photo, String> {

    Photo findByData(byte[] data);
    List<Photo> findAllByUtilisationIs(String utilisation);
}
