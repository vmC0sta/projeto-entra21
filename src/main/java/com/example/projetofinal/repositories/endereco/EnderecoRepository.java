package com.example.projetofinal.repositories.endereco;

import com.example.projetofinal.entities.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
    Endereco findEnderecoByLogradouroAndNumeroAndComplemento(String logradouro, String numero, String complemento);

}
