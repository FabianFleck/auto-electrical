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
    public CustomerResponse(CustomerEntity entity) {
        this(entity.getId(),
                entity.getName(),
                entity.getDocument(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getCreationDate(),
                entity.getUpdateDate());
    }
}
