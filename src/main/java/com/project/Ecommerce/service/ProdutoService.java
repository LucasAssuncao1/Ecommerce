package com.project.ecommerce.service;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ecommerce.api.converters.Converter;
import com.project.ecommerce.api.request.ProdutoCreateRequest;
import com.project.ecommerce.api.request.ProdutoUpdateRequest;
import com.project.ecommerce.api.response.ProdutoResponse;
import com.project.ecommerce.model.Produto;
import com.project.ecommerce.model.Endereco;
import com.project.ecommerce.repository.ProdutoRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
// @AllArgsConstructor
@NoArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private Converter converter;

    @Transactional(readOnly = true)
    public List<ProdutoResponse> list (){
        return converter.mapCollection(produtoRepository.findAll(), ProdutoResponse.class);
         
    }

    @Transactional(readOnly = true)
    public Page<ProdutoResponse> list (Pageable pageable){

        return converter.mapPage(produtoRepository.findAll(pageable), ProdutoResponse.class);
    }

    @Transactional(readOnly = true)
    public Produto acharProduto (Long id){
        return produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public ProdutoResponse buscar (Long id){
        return converter.map(this.acharProduto(id), ProdutoResponse.class); 
    }

    public ProdutoResponse criar(ProdutoCreateRequest request) {
        Produto Produto = new Produto();

        
        // Produto.setNome(request.getNome());
        // Produto.setTelefone(request.getTelefone());
        // Produto.setCpf(request.getCpf());
        // Produto.setEmail(request.getEmail());
        // Produto.setEndereco(request.getEndereco());

        return converter.map(this.salvar(Produto), ProdutoResponse.class);
    }

    public Produto salvar (Produto Produto){
        return produtoRepository.save(Produto);
    }

    public ProdutoResponse atualizar (Long produtoId, ProdutoUpdateRequest request){
       Produto produto =  this.acharProduto(produtoId);

       request.atualizar(produto);

       return converter.map(produto, ProdutoResponse.class);
        
    }

    @Transactional
    public void deletar (Long id){
       if (produtoRepository.existsById(id)) {
        produtoRepository.deleteById(id);
       } else {
        throw new RuntimeException("Produto não encontrado");
       }
    }



}
