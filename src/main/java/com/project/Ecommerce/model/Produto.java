package com.project.Ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidadeEstoque;
    private BigDecimal valorCusto;
    private BigDecimal valorVenda;
    private LocalDate dataCadastro;
    private String observacao;
    
}
