package br.com.auto.electrical.model.response;

import br.com.auto.electrical.model.enumeration.ServiceCarStatusEnum;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public record ServiceCarResponse(
        String description,
        CustomerResponse customer,
        CarResponse car,
        Integer guarantee,
        BigInteger totalValue,
        ServiceCarStatusEnum status,
        LocalDateTime creationDate,
        LocalDateTime updateDate,
        List<ServiceCarProductResponse> products
) {
}
