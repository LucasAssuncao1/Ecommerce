package com.project.Ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Endereco {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "enderecoId")
    private Long id;
    private String cep;
    private String rua;
    private String numero;

    @OneToOne(mappedBy = "endereco")
    @JsonBackReference
    private Cliente cliente;

}
