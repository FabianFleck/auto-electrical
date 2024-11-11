package br.com.auto.electrical.model.response;

import br.com.auto.electrical.model.entity.CustomerEntity;

import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String name,
        Long document,
        Long phone,
        String email,
        LocalDateTime creationDate,
        LocalDateTime updateDate
) {
}
