package br.com.faculdadecatolicapb.ms_produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank(message = "O nome do produto é obrigatório")
        String nome,

        @NotNull(message = "É preciso informar o nome do produto")
        @Positive(message = "O valor deve ser maior que 0")
        BigDecimal valor,

        @NotNull(message = "O estoque é obrigatório")
        @Positive(message = "O estoque deve ser maior que 0")
        Integer estoque) {}
