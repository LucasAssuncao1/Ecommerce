package com.project.ecommerce.api.request;

import java.math.BigDecimal;
import java.util.List;

import com.project.ecommerce.model.Cliente;
import com.project.ecommerce.model.Produto;

import lombok.Data;

@Data
public class PedidoUpdateRequest {
    
   private Cliente cliente;

   private List<Produto> produtos;

    private BigDecimal descontoNoTotal;
    private BigDecimal valorTotal;
}
