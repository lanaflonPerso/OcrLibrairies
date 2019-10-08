package com.books.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Hibernate :
 * Permet la création en base de données de la table Photo
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public @Data class Photo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NonNull
    private String fileName;

    @NonNull
    private String fileType;

    @NonNull
    @Lob
    private byte[] data;

    @NonNull
    private String utilisation;





}
