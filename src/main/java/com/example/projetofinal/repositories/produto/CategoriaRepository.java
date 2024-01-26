package com.example.projetofinal.repositories.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetofinal.entities.produto.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	Categoria findByDescricao(String descricao);

}
