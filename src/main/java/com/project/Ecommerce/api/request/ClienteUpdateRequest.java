package com.project.ecommerce.api.request;

import com.project.ecommerce.model.Cliente;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteUpdateRequest {
    
    private String nome;

    private String telefone;

    private String cpf;

    private String email;

    
    public void atualizar (Cliente cliente){
        cliente.setNome(nome != null ? nome : cliente.getNome());
        cliente.setTelefone(telefone != null ? telefone : cliente.getTelefone());
        cliente.setCpf(cpf != null ? cpf : cliente.getCpf());
        cliente.setEmail(email != null ? email : cliente.getEmail());

    }
}
