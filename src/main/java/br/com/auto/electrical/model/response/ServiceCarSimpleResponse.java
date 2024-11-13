package br.com.auto.electrical.model.response;

import br.com.auto.electrical.model.enumeration.ServiceCarStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ServiceCarSimpleResponse(
        String description,
        BigDecimal totalValue,
        ServiceCarStatusEnum status,
        LocalDateTime creationDate,
        LocalDateTime updateDate,
        CustomerSimpleResponse customer,
        CarSimpleResponse car,
        List<ServiceCarProductResponse> products
) {
}
