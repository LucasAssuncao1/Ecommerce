package com.project.ecommerce.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.api.request.ClienteCreateRequest;
import com.project.ecommerce.api.request.ClienteUpdateRequest;
import com.project.ecommerce.api.response.ClienteResponse;
import com.project.ecommerce.service.ClienteService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/clientes")
// @AllArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/todos")
    public List<ClienteResponse> listar() {
        return clienteService.list();
    }

    @GetMapping
    public Page<ClienteResponse> listar(Pageable pageable) {
        return clienteService.list(pageable);
    }

    @GetMapping("/{id}")
    public ClienteResponse buscar(@PathVariable Long id) {
        return clienteService.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponse criar( @RequestBody ClienteCreateRequest request) {
        return clienteService.criar(request);
    }

    @PutMapping("/{clienteId}")
    public ClienteResponse atualizar(@PathVariable Long clienteId, @RequestBody ClienteUpdateRequest request) {
        return clienteService.atualizar(clienteId, request);
    }

    @DeleteMapping("/{clienteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long clienteId) {
        clienteService.deletar(clienteId);
    }

}