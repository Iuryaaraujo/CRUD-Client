package com.iurysouzaaraujo.CRUD.e.VALIDACOES.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ErroPersonalizado{
    private List<FildMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FildMessage> getErrors() {
        return errors;
    }
    public void addError(String fieldName, String message) {
        errors.add(new FildMessage(fieldName, message));
    }
}
