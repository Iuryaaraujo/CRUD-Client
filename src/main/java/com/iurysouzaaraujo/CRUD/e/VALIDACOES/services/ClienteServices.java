package com.iurysouzaaraujo.CRUD.e.VALIDACOES.services;

import com.iurysouzaaraujo.CRUD.e.VALIDACOES.dto.ClienteDTO;
import com.iurysouzaaraujo.CRUD.e.VALIDACOES.entities.Cliente;
import com.iurysouzaaraujo.CRUD.e.VALIDACOES.repositories.ClienteRepository;
import com.iurysouzaaraujo.CRUD.e.VALIDACOES.services.excecoes.ExcecaoDeRecursoNaoEncontrado;
import com.iurysouzaaraujo.CRUD.e.VALIDACOES.services.excecoes.ExcecaoDeBancoDeDados;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findALL(Pageable pageable){
        Page<Cliente> result = repository.findAll(pageable);
        return result.map(x -> new ClienteDTO(x));
    }

    @Transactional(readOnly = true) // readOnly somente de leitura
    public  ClienteDTO findbyId(Long id) {
        Cliente client = repository.findById(id).orElseThrow(
                () -> new ExcecaoDeRecursoNaoEncontrado("Recurso não encontrado"));
        return new ClienteDTO(client);
    }
    @Transactional
    public  ClienteDTO insert(ClienteDTO dto) {
        Cliente entity = new Cliente();
        copiarDtoParaEntidade(dto, entity);
        entity = repository.save(entity);
        return new ClienteDTO(entity);
    }

    @Transactional
    public  ClienteDTO update(Long id, ClienteDTO dto) {
        try {
            Cliente entity = repository.getReferenceById(id);
            copiarDtoParaEntidade(dto, entity);
            entity = repository.save(entity);
            return new ClienteDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ExcecaoDeRecursoNaoEncontrado("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        // Se o ID não existir vou lançar a exceção
        if (!repository.existsById(id)) {
            throw new ExcecaoDeRecursoNaoEncontrado("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        // Tentando apagar um cliente
        catch (DataIntegrityViolationException e) {
            throw new ExcecaoDeBancoDeDados("Falha de integridade referencial");
        }
    }

    private void copiarDtoParaEntidade(ClienteDTO dto, Cliente entity) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setRenda(dto.getRenda());
        entity.setDataDeNascimento(dto.getDataDeNascimento());
        entity.setQuantidadeDeFilhos(dto.getQuantidadeDeFilhos());
    }
}
