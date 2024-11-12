package br.com.auto.electrical.model.response;

import br.com.auto.electrical.model.enumeration.CarColorEnum;

import java.time.LocalDateTime;

public record CarResponse(
        Long id,
        String plate,
        CarColorEnum color,
        String model,
        Integer year,
        CustomerResponse customer,
        LocalDateTime creationDate,
        LocalDateTime updateDate
) {
}
