package br.com.auto.electrical.model.request;

import br.com.auto.electrical.model.enumeration.ServiceCarStatusEnum;

import java.math.BigInteger;
import java.util.List;

public record ServiceCarRequest(
        String description,
        Long customerId,
        Long carId,
        Integer guarantee,
        BigInteger totalValue,
        ServiceCarStatusEnum status,
        List<ServiceCarProductRequest> products
) {
}
