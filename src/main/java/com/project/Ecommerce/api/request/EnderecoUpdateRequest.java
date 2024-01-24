package com.project.ecommerce.api.request;

import com.project.ecommerce.model.Endereco;

import lombok.Data;

@Data
public class EnderecoUpdateRequest {

    private String cep;
    private String rua;
    private String numero;
    
    public void atualizar (Endereco endereco){
        endereco.setCep(cep != null ? cep : endereco.getCep());
        endereco.setCep(rua != null ? rua : endereco.getRua());
        endereco.setCep(numero != null ? numero : endereco.getNumero());
    }
}
