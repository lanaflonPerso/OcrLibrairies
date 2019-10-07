package com.users.exceptions;
/**
 * Exception lié à l'inscription d'un utilisateur
 */
public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object resourId) {
        super(resourId != null ? resourId.toString() : null);
    }
}
