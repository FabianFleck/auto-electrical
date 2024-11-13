package br.com.auto.electrical.model.response;

public record CarSimpleResponse(
        Long id,
        String plate,
        String model
) {
}
