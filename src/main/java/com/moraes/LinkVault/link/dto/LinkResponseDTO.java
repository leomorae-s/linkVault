package com.moraes.LinkVault.link.dto;

import com.moraes.LinkVault.link.LinkModel;

public record LinkResponseDTO(
    Integer id,
    String link,
    String description
) {

    public static LinkResponseDTO from(LinkModel model) {
        return new LinkResponseDTO(model.getid(), model.getLink(), model.getDescription());
    }
}
