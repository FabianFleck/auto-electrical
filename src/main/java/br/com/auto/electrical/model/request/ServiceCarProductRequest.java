package br.com.auto.electrical.model.request;

import java.math.BigInteger;

public record ServiceCarProductRequest(
        Integer quantity,
        String description,
        BigInteger unitValue,
        BigInteger totalValue
) {
}
