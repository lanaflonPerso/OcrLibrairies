package com.books.repository.book;



import com.books.model.book.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JPA Initialisation de l'entity Photo
 */
@Repository
public interface ICoverRepository extends JpaRepository<Cover, String> {

    Cover findByData(byte[] data);
    List<Cover> findAllByUseIs(String use);
}
