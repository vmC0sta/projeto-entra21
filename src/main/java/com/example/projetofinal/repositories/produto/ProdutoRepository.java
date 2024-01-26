package com.example.projetofinal.repositories.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetofinal.entities.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
