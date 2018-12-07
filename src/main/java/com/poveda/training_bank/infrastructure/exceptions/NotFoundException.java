package com.poveda.training_bank.infrastructure.exceptions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BaseException {

    private static String DEFAULT_MESSAGE = "Cliente não encontrado.";
    private Set<String> errors;

    public NotFoundException(String message, Object[] params) {
        super(message, params);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public NotFoundException(Set<String> errors) {
        super(StringUtils.join(errors, ", "));
        this.errors = errors;
    }


    public Set<String> getErrors() {
        return errors;
    }


}
