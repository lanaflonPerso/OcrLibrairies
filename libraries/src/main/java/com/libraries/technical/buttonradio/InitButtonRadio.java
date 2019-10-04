package com.libraries.technical.buttonradio;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Permet de personaliser les boutons radio
 */
@RequiredArgsConstructor
public @Data class InitButtonRadio {

    @NonNull
    private boolean value;

    @NonNull
    private String text;


}
