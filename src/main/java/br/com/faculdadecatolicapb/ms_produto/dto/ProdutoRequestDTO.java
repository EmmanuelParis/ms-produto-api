package br.com.faculdadecatolicapb.ms_produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank(message = "O nome do produto é obrigatório")
        String nome,

        @Positive(message = "O valor deve ser maior que 0")
        BigDecimal valor) {
}
