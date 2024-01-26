package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
