package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
