package com.example.projetofinal.services.endereco;

import com.example.projetofinal.entities.endereco.Bairro;
import com.example.projetofinal.exceptions.ResourceAlreadyExistsException;
import com.example.projetofinal.exceptions.ResourceNotFoundException;
import com.example.projetofinal.repositories.endereco.BairroRepository;
import com.example.projetofinal.services.Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class BairroService implements Service<Bairro> {

    private final BairroRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Bairro> findAll() {
        return repository.findAll();
    }

    @Override
    public Bairro findById(Long id) {
        Optional<Bairro> optional=repository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("Munícipio","id",id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public Bairro save(Bairro bairro) {
        if (repository.findByDescricao(bairro.getDescricao()) != null )
            throw new ResourceAlreadyExistsException("Esse bairro já existe");
        return repository.save(bairro);
    }

    @Override
    public Bairro update(Long id, Bairro bairroNovo) {
        if (repository.findByDescricao(bairroNovo.getDescricao()) != null )
            throw new ResourceAlreadyExistsException("Esse bairro já existe");
        Bairro bairro = findById(id);
        bairroNovo.setId(bairro.getId());
        mapper.map(bairroNovo,bairro);
        return repository.save(bairro);
    }
}
