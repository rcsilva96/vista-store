package com.techvista.vistastore.application.dto;

import com.techvista.vistastore.domain.model.SellModel;

public record SellResponseDTO(
    String message,
    SellModel sell
) {}
