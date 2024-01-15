package com.project.Ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "pedidoId")
    private Long id;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    @JsonManagedReference
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<Produto> produtos;

    private BigDecimal descontoNoTotal;
    private BigDecimal valorTotal;
    
}
