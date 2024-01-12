package com.example.projetofinal.repositories.endereco;

import com.example.projetofinal.entities.endereco.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Estado findByDescricao(String descricao);

}
