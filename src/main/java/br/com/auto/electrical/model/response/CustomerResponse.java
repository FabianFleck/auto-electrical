package br.com.auto.electrical.model.response;

import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String name,
        String document,
        String phone,
        String email,
        LocalDateTime creationDate,
        LocalDateTime updateDate
) {
}
