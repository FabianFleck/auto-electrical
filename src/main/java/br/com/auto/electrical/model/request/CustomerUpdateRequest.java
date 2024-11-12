package br.com.auto.electrical.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CustomerUpdateRequest(
        @Schema(description = "Nome do cliente", example = "Fulano 2")
        String name,
        @Schema(description = "Telefone do cliente", example = "6635540242")
        String phone,
        @Schema(description = "E-mail do cliente", example = "fulano2@example2.com.br")
        String email
) {
}
