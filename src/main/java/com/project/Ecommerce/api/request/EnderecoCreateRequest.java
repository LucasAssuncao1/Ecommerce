package com.project.ecommerce.api.request;

import lombok.Data;

@Data
public class EnderecoCreateRequest {

    private String cep;
    private String rua;
    private String numero;
    
}
