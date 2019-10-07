package com.mbooks.controller.dto.photo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
public class PhotoUpdateDto {

    @Id
    private String id;

    @NonNull
    private String fileName;

    @NonNull
    private String fileType;

    @NonNull
    @Lob
    private byte[] data;
}
