package br.com.auto.electrical.model.response;

import java.math.BigInteger;

public record ServiceCarProductResponse(
        Long id,
        Integer quantity,
        String description,
        BigInteger unitValue,
        BigInteger totalValue
) {
}
