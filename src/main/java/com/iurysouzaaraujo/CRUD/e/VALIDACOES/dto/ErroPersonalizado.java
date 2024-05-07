package com.iurysouzaaraujo.CRUD.e.VALIDACOES.dto;

import java.time.Instant;

public class ErroPersonalizado {

    // vai aparecer o error personalisado no POSTMAN
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public ErroPersonalizado(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
