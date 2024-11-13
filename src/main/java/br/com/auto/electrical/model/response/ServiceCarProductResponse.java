package br.com.auto.electrical.model.response;

import java.math.BigDecimal;

public record ServiceCarProductResponse(
        Long id,
        Integer quantity,
        String description,
        BigDecimal unitValue,
        BigDecimal totalValue
) {
}
