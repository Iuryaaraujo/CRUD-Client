package com.iurysouzaaraujo.CRUD.e.VALIDACOES.services.excecoes;

public class ExcecaoDeRecursoNaoEncontrado extends RuntimeException{
    // RuntimeException não me exigir Try e Catch

    // Exigir uma mensagem na hora de instancia o objeto
    public ExcecaoDeRecursoNaoEncontrado(String msg) {
        super(msg);
    }
}
