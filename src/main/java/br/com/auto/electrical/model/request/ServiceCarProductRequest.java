package br.com.auto.electrical.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ServiceCarProductRequest(
        @Schema(description = "Descrição do produto", example = "Troca de óleo do civic")
        String description,
        @Schema(description = "Quantidade do produto", example = "1")
        Integer quantity,
        @Schema(description = "Valor unitário do produto", example = "99.90")
        BigDecimal unitValue,
        @Schema(description = "Valor total do produto (quantidade vezes o valor unitário)", example = "99.90")
        BigDecimal totalValue
) {
}
