package com.project.ecommerce.model;

import java.util.Collection;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity
// @SequenceGenerator(name = "generator_usuario", sequenceName = "sequence_usuario", initialValue = 1, allocationSize = 1)
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class Usuario  {

//     @Id
//     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_usuario")
//     private Long id;

//     @Column(nullable = false)
//     private String nome;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false)
//     private String senha;

   

    // Daqui pra baixo é implementação do userdetails

    // @Override
    // @JsonIgnore
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return null;
    // }

    // @JsonIgnore
    // @Override
    // public String getPassword() {
    //     return senha;
    // }

    // @JsonIgnore
    // @Override
    // public String getUsername() {
    //     return email;
    // }

    // @JsonIgnore
    // @Override
    // public boolean isAccountNonExpired() {
    //     return true;
    // }

    // @JsonIgnore
    // @Override
    // public boolean isAccountNonLocked() {
    //     return true;
    // }

    // @JsonIgnore
    // @Override
    // public boolean isCredentialsNonExpired() {
    //     return true;
    // }

    // @JsonIgnore
    // @Override
    // public boolean isEnabled() {
    //     return true;
    // }

// }
