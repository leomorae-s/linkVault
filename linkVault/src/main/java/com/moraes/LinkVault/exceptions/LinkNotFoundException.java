package com.moraes.LinkVault.exceptions;

public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException() {
        super("Link não encontrado.");
    }
}
