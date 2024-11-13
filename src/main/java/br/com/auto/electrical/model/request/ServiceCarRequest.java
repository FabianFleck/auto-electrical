package br.com.auto.electrical.model.request;

import br.com.auto.electrical.model.enumeration.ServiceCarStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;

public record ServiceCarRequest(
        @Schema(description = "Descrição do serviço", example = "Troca de óleo")
        String description,
        @Schema(description = "Identificador do cliente", example = "1")
        Long customerId,
        @Schema(description = "Identificador do carro", example = "1")
        Long carId,
        @Schema(description = "Tempo de garantia do serviço (em meses)", example = "3")
        Integer guarantee,
        @Schema(description = "Valor total do serviço", example = "99.90")
        BigDecimal totalValue,
        @Schema(description = "Status do serviço", example = "OPEN")
        ServiceCarStatusEnum status,
        @Schema(description = "Produtos do serviço")
        List<ServiceCarProductRequest> products
) {
}
