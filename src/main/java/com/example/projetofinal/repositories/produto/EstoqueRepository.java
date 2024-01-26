package com.example.projetofinal.repositories.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetofinal.entities.produto.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
