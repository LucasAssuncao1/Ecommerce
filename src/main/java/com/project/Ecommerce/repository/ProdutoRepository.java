package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
