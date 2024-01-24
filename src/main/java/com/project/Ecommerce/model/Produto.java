package com.project.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "produtoId")
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;

    private Integer quantidadeEstoque;
    private BigDecimal valorCusto;
    private BigDecimal valorVenda;
    private LocalDate dataCadastro;
    private String observacao;
    
}
