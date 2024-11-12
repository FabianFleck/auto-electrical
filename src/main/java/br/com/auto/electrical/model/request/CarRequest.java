package br.com.auto.electrical.model.request;

import br.com.auto.electrical.model.enumeration.CarColorEnum;

public record CarRequest(
        String plate,
        CarColorEnum color,
        String model,
        Integer year,
        Long clientID
) {
}
