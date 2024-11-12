package br.com.auto.electrical.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CustomerRequest(
        @Schema(description = "Nome do cliente", example = "Fulano")
        String name,
        @Schema(description = "Documento do cliente", example = "31505097002")
        String document,
        @Schema(description = "Telefone do cliente", example = "66989771003")
        String phone,
        @Schema(description = "E-mail do cliente", example = "fulano@example.com.br")
        String email
) {
}