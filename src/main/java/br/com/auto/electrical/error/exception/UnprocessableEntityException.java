package br.com.auto.electrical.error.exception;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public class UnprocessableEntityException extends AutoException {
    public UnprocessableEntityException(String message) {
        super(UNPROCESSABLE_ENTITY, message);
    }
}
