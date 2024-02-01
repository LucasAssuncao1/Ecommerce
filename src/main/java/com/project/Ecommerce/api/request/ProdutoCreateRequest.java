package com.project.ecommerce.api.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.project.ecommerce.model.Cliente;
import com.project.ecommerce.model.Endereco;
import com.project.ecommerce.model.Pedido;
import com.project.ecommerce.model.Produto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProdutoCreateRequest {
    
   private String nome;

    // private Pedido pedido;

    private Integer quantidadeEstoque;
    private BigDecimal valorCusto;
    private BigDecimal valorVenda;
    private LocalDate dataCadastro;
    private String observacao;
}
