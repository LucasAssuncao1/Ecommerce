package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
