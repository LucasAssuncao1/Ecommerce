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

import com.project.ecommerce.api.request.EnderecoCreateRequest;
import com.project.ecommerce.api.request.EnderecoUpdateRequest;
import com.project.ecommerce.api.response.EnderecoResponse;
import com.project.ecommerce.service.EnderecoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/enderecos")
// @AllArgsConstructor
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/todos")
    public List<EnderecoResponse> listar() {
        return enderecoService.list();
    }

    @GetMapping
    public Page<EnderecoResponse> listar(Pageable pageable) {
        return enderecoService.list(pageable);
    }

    @GetMapping("/{enderecoId}")
    public EnderecoResponse buscar(@PathVariable Long enderecoId) {
        return enderecoService.buscar(enderecoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoResponse criar(@RequestBody EnderecoCreateRequest request) {
        return enderecoService.criar(request);
    }

    @PutMapping("/{enderecoId}")
    public EnderecoResponse atualizar(@PathVariable Long enderecoId, @RequestBody EnderecoUpdateRequest request) {
        return enderecoService.atualizar(enderecoId, request);
    }

    @DeleteMapping("/{enderecoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long enderecoId) {
        enderecoService.deletar(enderecoId);
    }

}