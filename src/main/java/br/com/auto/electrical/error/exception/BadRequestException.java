package br.com.auto.electrical.error.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends AutoException {
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
