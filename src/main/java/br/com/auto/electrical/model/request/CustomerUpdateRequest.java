package br.com.auto.electrical.model.request;

public record CustomerUpdateRequest(
        String name,
        Long phone,
        String email
) {
}
