package com.example.projetofinal.services.pessoa;

import com.example.projetofinal.entities.pessoa.Pessoa;
import com.example.projetofinal.exceptions.ResourceAlreadyExistsException;
import com.example.projetofinal.exceptions.ResourceNotFoundException;
import com.example.projetofinal.repositories.pessoa.PessoaRepository;
import com.example.projetofinal.services.Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class PessoaService implements Service<Pessoa> {
    private final PessoaRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    @Override
    public Pessoa findById(Long id) {
        Optional<Pessoa> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("Pessoa", "id", id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        if (repository.findPessoaByNomeAndIdentificacao(pessoa.getNome(), pessoa.getIdentificacao()) != null)
            throw new ResourceAlreadyExistsException("Essa pessoa já existe");
        return repository.save(pessoa);
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoaNova) {
        if (repository.findPessoaByNomeAndIdentificacao(pessoaNova.getNome(), pessoaNova.getIdentificacao()) != null)
            throw new ResourceAlreadyExistsException("Essa pessoa já existe");
        Pessoa pessoa = findById(id);
        pessoaNova.setId(pessoa.getId());
        mapper.map(pessoaNova,pessoa);
        return repository.save(pessoa);
    }
}
