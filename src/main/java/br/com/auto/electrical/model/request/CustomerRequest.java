package br.com.auto.electrical.model.request;

public record CustomerRequest(
        String name,
        Long document,
        Long phone,
        String email
) {
}
