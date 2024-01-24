package com.project.ecommerce.api.request;

import com.project.ecommerce.model.Endereco;

import lombok.Data;

@Data
public class ClienteCreateRequest {
    
    // private Long id; 
    private String nome;

    private String telefone;

    private String cpf;

    private String email;

    // private List<Pedido> pedidos;

    
    private Endereco endereco;
}
