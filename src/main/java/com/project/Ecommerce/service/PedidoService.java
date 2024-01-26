package com.project.ecommerce.service;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ecommerce.api.converters.Converter;
import com.project.ecommerce.api.request.PedidoCreateRequest;
import com.project.ecommerce.api.request.PedidoUpdateRequest;
import com.project.ecommerce.api.response.PedidoResponse;
import com.project.ecommerce.model.Pedido;
import com.project.ecommerce.model.Endereco;
import com.project.ecommerce.repository.PedidoRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
// @AllArgsConstructor
@NoArgsConstructor
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private Converter converter;

    @Transactional(readOnly = true)
    public List<PedidoResponse> list (){
        return converter.mapCollection(pedidoRepository.findAll(), PedidoResponse.class);
         
    }

    @Transactional(readOnly = true)
    public Page<PedidoResponse> list (Pageable pageable){

        return converter.mapPage(pedidoRepository.findAll(pageable), PedidoResponse.class);
    }

    @Transactional(readOnly = true)
    public Pedido acharPedido (Long id){
        return pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public PedidoResponse buscar (Long id){
        return converter.map(this.acharPedido(id), PedidoResponse.class); 
    }

    public PedidoResponse criar(PedidoCreateRequest request) {
        Pedido pedido = new Pedido();

        
        // Pedido.setNome(request.getNome());
        // Pedido.setTelefone(request.getTelefone());
        // Pedido.setCpf(request.getCpf());
        // Pedido.setEmail(request.getEmail());
        // Pedido.setEndereco(request.getEndereco());

        return converter.map(this.salvar(Pedido), PedidoResponse.class);
    }

    public Pedido salvar (Pedido Pedido){
        return pedidoRepository.save(Pedido);
    }

    public PedidoResponse atualizar (Long PedidoId, PedidoUpdateRequest request){
       Pedido Pedido =  this.acharPedido(PedidoId);

       request.atualizar(Pedido);

       return converter.map(Pedido, PedidoResponse.class);
        
    }

    @Transactional
    public void deletar (Long id){
       if (pedidoRepository.existsById(id)) {
        pedidoRepository.deleteById(id);
       } else {
        throw new RuntimeException("Pedido não encontrado");
       }
    }



}
