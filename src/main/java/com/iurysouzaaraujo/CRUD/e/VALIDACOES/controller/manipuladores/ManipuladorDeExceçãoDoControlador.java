package com.iurysouzaaraujo.CRUD.e.VALIDACOES.controller.manipuladores;

import com.iurysouzaaraujo.CRUD.e.VALIDACOES.dto.ErroPersonalizado;
import com.iurysouzaaraujo.CRUD.e.VALIDACOES.dto.ValidationError;
import com.iurysouzaaraujo.CRUD.e.VALIDACOES.services.excecoes.ExcecaoDeBancoDeDados;
import com.iurysouzaaraujo.CRUD.e.VALIDACOES.services.excecoes.ExcecaoDeRecursoNaoEncontrado;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ManipuladorDeExceçãoDoControlador {
    @ExceptionHandler(ExcecaoDeRecursoNaoEncontrado.class)
    public ResponseEntity<ErroPersonalizado> ExcecaoDeRecurso(ExcecaoDeRecursoNaoEncontrado e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPersonalizado erroPersonalizado = new ErroPersonalizado(Instant.now(), status.value(),e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(erroPersonalizado);
    }

    @ExceptionHandler(ExcecaoDeBancoDeDados.class)
    public ResponseEntity<ErroPersonalizado> ExcecaoDeBancoDeDados(ExcecaoDeBancoDeDados e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST; // codigo 404
        ErroPersonalizado erroPersonalizado = new ErroPersonalizado(Instant.now(), status.value(),e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(erroPersonalizado);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPersonalizado> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; // codigo 422 entidade improcessavel
        ValidationError err = new ValidationError(Instant.now(), status.value(),"Dados inválidos", request.getRequestURI());
        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }
}
