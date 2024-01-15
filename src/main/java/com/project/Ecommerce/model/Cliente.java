package com.project.Ecommerce.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "clienteId")
    private Long id; 
    private String nome;
    private String telefone;
    private String cpf;
    private String email;

    @OneToMany(mappedBy = "cliente")
    @JsonBackReference
    private List<Pedido> pedidos;

    @OneToOne
    @JoinColumn (name = "id")
    @JsonManagedReference
    private Endereco endereco;

    
}
