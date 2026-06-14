package com.moraes.LinkVault.exceptions;

public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException(Integer id) {
        super(String.format("Link de id %d não encontrado.", id));
    }
}
