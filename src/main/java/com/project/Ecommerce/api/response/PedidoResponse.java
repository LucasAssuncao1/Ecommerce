package com.project.ecommerce.api.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.project.ecommerce.model.Produto;

import lombok.Data;

@Data
public class PedidoResponse {

    private Long id;
    private LocalDateTime data;

    private ClienteResponse cliente;

    private List<Produto> produtos;

    private BigDecimal descontoNoTotal;
    private BigDecimal valorTotal;
    
}
