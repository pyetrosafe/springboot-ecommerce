package com.pyetrosafe.e_commerce.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRecordDto(
    @NotBlank String nome,
    @NotBlank String descricao,
    @NotBlank String cod_barras,
    @NotNull BigDecimal valor,
    Boolean ativo,
    String imagem,
    @NotNull Long quantidade
) {
}
