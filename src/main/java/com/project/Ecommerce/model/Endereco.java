package com.project.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Endereco {

    private Long id;
    private String cep;
    private String rua;
    private String numero;

    @OneToOne(mappedBy = "endereco")
    @JsonBackReference
    private Cliente cliente;

}
