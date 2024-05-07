package com.iurysouzaaraujo.CRUD.e.VALIDACOES.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Double renda;
    private LocalDate dataDeNascimento;
    private int quantidadeDeFilhos;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, Double renda, LocalDate dataDeNascimento, int quantidadeDeFilhos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
        this.dataDeNascimento = dataDeNascimento;
        this.quantidadeDeFilhos = quantidadeDeFilhos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getQuantidadeDeFilhos() {
        return quantidadeDeFilhos;
    }

    public void setQuantidadeDeFilhos(int quantidadeDeFilhos) {
        this.quantidadeDeFilhos = quantidadeDeFilhos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(getId(), cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
