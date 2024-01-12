package com.example.projetofinal.repositories.endereco;

import com.example.projetofinal.entities.endereco.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro,Long> {
    Bairro findByDescricao(String descricao);
}
