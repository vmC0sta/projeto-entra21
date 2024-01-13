package com.example.projetofinal.services.endereco;

import com.example.projetofinal.entities.endereco.Cep;
import com.example.projetofinal.exceptions.ResourceAlreadyExistsException;
import com.example.projetofinal.exceptions.ResourceNotFoundException;
import com.example.projetofinal.repositories.endereco.CepRepository;
import com.example.projetofinal.services.Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class CepService implements Service<Cep> {
    private final CepRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Cep> findAll() {
        return repository.findAll();
    }

    @Override
    public Cep findById(Long id) {
        Optional<Cep> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("Cep","id",id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public Cep save(Cep cep) {
        if (repository.findCepByDescricaoAndEndereco(cep.getDescricao(), cep.getEndereco()) != null){
            throw new ResourceAlreadyExistsException("Esse cep já existe");
        }
        return repository.save(cep);
    }

    @Override
    public Cep update(Long id, Cep cepNovo) {
        if (repository.findCepByDescricaoAndEndereco(cepNovo.getDescricao(), cepNovo.getEndereco()) != null){
            throw new ResourceAlreadyExistsException("Esse cep já existe");
        }
        Cep cep = findById(id);
        cepNovo.setId(cep.getId());
        mapper.map(cepNovo,cep);
        return repository.save(cep);
    }
}
