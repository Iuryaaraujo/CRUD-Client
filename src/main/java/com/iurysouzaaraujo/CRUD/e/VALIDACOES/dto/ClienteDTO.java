package com.iurysouzaaraujo.CRUD.e.VALIDACOES.dto;

import com.iurysouzaaraujo.CRUD.e.VALIDACOES.entities.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClienteDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String nome;
    private String cpf;
    private Double renda;
    @PastOrPresent
    private LocalDate dataDeNascimento;
    private int quantidadeDeFilhos;

    public ClienteDTO(Long id, String nome, String cpf, Double renda, LocalDate dataDeNascimento, int quantidadeDeFilhos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
        this.dataDeNascimento = dataDeNascimento;
        this.quantidadeDeFilhos = quantidadeDeFilhos;
    }

    public ClienteDTO(Cliente entity) {
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
        renda = entity.getRenda();
        dataDeNascimento = entity.getDataDeNascimento();
        quantidadeDeFilhos = entity.getQuantidadeDeFilhos();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getRenda() {
        return renda;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public int getQuantidadeDeFilhos() {
        return quantidadeDeFilhos;
    }
}
