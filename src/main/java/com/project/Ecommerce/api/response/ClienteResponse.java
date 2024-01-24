package com.project.ecommerce.api.response;

import java.util.List;

import com.project.ecommerce.model.Pedido;

import lombok.Data;

@Data
public class ClienteResponse {
    
    private Long id; 
    private String nome;
    private String telefone;
    // private String cpf;
    private String email;

    private List<Pedido> pedidos;

    private EnderecoResponse endereco;
}
