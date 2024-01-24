package com.project.ecommerce.service;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ecommerce.api.converters.Converter;
import com.project.ecommerce.api.request.ClienteCreateRequest;
import com.project.ecommerce.api.request.ClienteUpdateRequest;
import com.project.ecommerce.api.response.ClienteResponse;
import com.project.ecommerce.model.Cliente;
import com.project.ecommerce.model.Endereco;
import com.project.ecommerce.repository.ClienteRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
// @AllArgsConstructor
@NoArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private Converter converter;

    @Transactional(readOnly = true)
    public List<ClienteResponse> list (){
        return converter.mapCollection(clienteRepository.findAll(), ClienteResponse.class);
         
    }

    @Transactional(readOnly = true)
    public Page<ClienteResponse> list (Pageable pageable){

        return converter.mapPage(clienteRepository.findAll(pageable), ClienteResponse.class);
    }

    @Transactional(readOnly = true)
    public Cliente acharCliente (Long id){
        return clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public ClienteResponse buscar (Long id){
        return converter.map(this.acharCliente(id), ClienteResponse.class); 
    }

    public ClienteResponse criar(ClienteCreateRequest request) {
        Cliente cliente = new Cliente();

        // Endereco endereco = new Endereco();

        
        
        cliente.setNome(request.getNome());
        cliente.setTelefone(request.getTelefone());
        cliente.setCpf(request.getCpf());
        cliente.setEmail(request.getEmail());
        cliente.setEndereco(request.getEndereco());

        return converter.map(this.salvar(cliente), ClienteResponse.class);
    }

    public Cliente salvar (Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public ClienteResponse atualizar (Long clienteId, ClienteUpdateRequest request){
       Cliente cliente =  this.acharCliente(clienteId);

       request.atualizar(cliente);

       return converter.map(cliente, ClienteResponse.class);
        
    }

    @Transactional
    public void deletar (Long id){
       if (clienteRepository.existsById(id)) {
        clienteRepository.deleteById(id);
       } else {
        throw new RuntimeException("Cliente não encontrado");
       }
    }



}
