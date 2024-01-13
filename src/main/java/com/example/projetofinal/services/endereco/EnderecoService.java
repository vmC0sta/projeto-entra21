package com.example.projetofinal.services.endereco;


import com.example.projetofinal.entities.endereco.Endereco;
import com.example.projetofinal.exceptions.ResourceAlreadyExistsException;
import com.example.projetofinal.exceptions.ResourceNotFoundException;
import com.example.projetofinal.repositories.endereco.EnderecoRepository;
import com.example.projetofinal.services.Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class EnderecoService implements Service<Endereco> {
    private final EnderecoRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Endereco> findAll() {
        return repository.findAll();
    }

    @Override
    public Endereco findById(Long id) {
        Optional<Endereco> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("Endereço", "id", id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public Endereco save(Endereco endereco) {
        if (repository.findEnderecoByLogradouroAndNumeroAndComplemento(endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento()) != null)
            throw new ResourceAlreadyExistsException("Esse endereço já existe");
        return repository.save(endereco);
    }

    @Override
    public Endereco update(Long id, Endereco enderecoNovo) {
        if (repository.findEnderecoByLogradouroAndNumeroAndComplemento(enderecoNovo.getLogradouro(), enderecoNovo.getNumero(),enderecoNovo.getComplemento()) != null)
            throw new ResourceAlreadyExistsException("Esse endereço já existe");
        Endereco endereco = findById(id);
        enderecoNovo.setId(endereco.getId());
        mapper.map(enderecoNovo, endereco);
        return repository.save(endereco);
    }
}
