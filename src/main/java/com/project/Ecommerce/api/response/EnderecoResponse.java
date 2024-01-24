package com.project.ecommerce.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.ecommerce.model.Cliente;

import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class EnderecoResponse {
   
    private Long id;
    private String cep;
    private String rua;
    private String numero;

    @JsonIgnore
    private ClienteResponse cliente;
}
