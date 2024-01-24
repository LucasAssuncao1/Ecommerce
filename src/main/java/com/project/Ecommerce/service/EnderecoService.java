package com.project.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ecommerce.api.converters.Converter;
import com.project.ecommerce.api.request.EnderecoCreateRequest;
import com.project.ecommerce.api.request.EnderecoUpdateRequest;
import com.project.ecommerce.api.response.EnderecoResponse;
import com.project.ecommerce.model.Endereco;
import com.project.ecommerce.repository.EnderecoRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
// @AllArgsConstructor
@NoArgsConstructor
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private Converter converter;

    @Transactional(readOnly = true)
    public List<EnderecoResponse> list (){
        return converter.mapCollection(enderecoRepository.findAll(), EnderecoResponse.class);
         
    }

    @Transactional(readOnly = true)
    public Page<EnderecoResponse> list (Pageable pageable){

        return converter.mapPage(enderecoRepository.findAll(pageable), EnderecoResponse.class);
    }

    @Transactional(readOnly = true)
    public Endereco acharEndereco (Long id){
        return enderecoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public EnderecoResponse buscar (Long id){
        return converter.map(this.acharEndereco(id), EnderecoResponse.class); 
    }

    public EnderecoResponse criar(EnderecoCreateRequest request) {
        Endereco endereco = new Endereco();

        endereco.setCep(request.getCep());
        endereco.setRua(request.getRua());
        endereco.setNumero(request.getNumero());
        
        return converter.map(this.salvar(endereco),EnderecoResponse.class);
    }

    public Endereco salvar (Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public EnderecoResponse atualizar (Long enderecoId, EnderecoUpdateRequest request){
       Endereco endereco =  this.acharEndereco(enderecoId);

       request.atualizar(endereco);

       return converter.map(endereco, EnderecoResponse.class);
        
    }

    @Transactional
    public void deletar (Long id){
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Endereço não encontrado");
        }

    }



}
