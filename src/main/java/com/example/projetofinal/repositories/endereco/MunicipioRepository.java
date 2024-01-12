package com.example.projetofinal.repositories.endereco;

import com.example.projetofinal.entities.endereco.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio,Long> {
    Municipio findByDescricao(String descricao);
}
