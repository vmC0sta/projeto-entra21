package com.example.projetofinal.repositories.pessoa;

import com.example.projetofinal.entities.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    Pessoa findPessoaByNomeAndIdentificacao(String nome, String identificacao);

}
