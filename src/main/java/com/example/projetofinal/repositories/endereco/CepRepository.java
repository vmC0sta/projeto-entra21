package com.example.projetofinal.repositories.endereco;

import com.example.projetofinal.entities.endereco.Cep;
import com.example.projetofinal.entities.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<Cep,Long> {

    Cep findCepByDescricaoAndEndereco(String descricao, Endereco endereco);

}
