package com.example.projetofinal.repositories.endereco;

import com.example.projetofinal.entities.endereco.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    Pais findByDescricao(String descricao);

}
