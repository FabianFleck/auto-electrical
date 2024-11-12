package br.com.auto.electrical.model.request;

import br.com.auto.electrical.model.enumeration.CarColorEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public record CarRequest(
        @Schema(description = "Placa do carro", example = "LVQ9451")
        String plate,
        @Schema(description = "Placa do carro", example = "BLACK")
        CarColorEnum color,
        @Schema(description = "Modelo do carro", example = "Up TSI")
        String model,
        @Schema(description = "Ano do carro", example = "2016")
        Integer year,
        @Schema(description = "Id do cliente", example = "1")
        Long clientID
) {
}
