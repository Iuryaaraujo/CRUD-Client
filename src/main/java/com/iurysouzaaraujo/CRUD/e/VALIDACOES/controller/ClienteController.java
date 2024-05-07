package com.iurysouzaaraujo.CRUD.e.VALIDACOES.controller;

import com.iurysouzaaraujo.CRUD.e.VALIDACOES.dto.ClienteDTO;
import com.iurysouzaaraujo.CRUD.e.VALIDACOES.services.ClienteServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clientes") // ROTA
public class ClienteController {

    @Autowired
    private ClienteServices service;

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable) {
        Page<ClienteDTO> dto = service.findALL(pageable);
        return ResponseEntity.ok(dto);
        // ok codigo 200
    }

    @GetMapping(value = "/{id}")
    // @PathVariable para casar os id na buscar
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        ClienteDTO dto = service.findbyId(id);
        return ResponseEntity.ok(dto);
        // ok codigo 200
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri(); // codigo 201 Recurso criado com sucesso
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id,@Valid @RequestBody ClienteDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
