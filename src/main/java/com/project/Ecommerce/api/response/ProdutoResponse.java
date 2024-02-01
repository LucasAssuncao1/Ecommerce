package com.project.ecommerce.api.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.project.ecommerce.model.Pedido;
import com.project.ecommerce.model.Produto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProdutoResponse {


    private Long id;
    private String nome;

    // private Pedido pedido;

    private Integer quantidadeEstoque;
    private BigDecimal valorCusto;
    private BigDecimal valorVenda;
    private LocalDate dataCadastro;
    private String observacao;
    
}
