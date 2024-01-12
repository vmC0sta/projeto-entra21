package com.example.projetofinal.services.endereco;

import com.example.projetofinal.entities.endereco.Estado;
import com.example.projetofinal.exceptions.ResourceAlreadyExistsException;
import com.example.projetofinal.exceptions.ResourceNotFoundException;
import com.example.projetofinal.repositories.endereco.EstadoRepository;
import com.example.projetofinal.services.Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class EstadoService implements Service<Estado> {

    private final EstadoRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<Estado> findAll() {
        return repository.findAll();
    }

    @Override
    public Estado findById(Long id) {
        Optional<Estado> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("Estado","id",id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public Estado save(Estado estado) {
        if (repository.findByDescricao(estado.getDescricao()) != null){
            throw new ResourceAlreadyExistsException("Esse estado já existe!");
        }
        return repository.save(estado);
    }

    @Override
    public Estado update(Long id, Estado estadoNovo) {
        if (repository.findByDescricao(estadoNovo.getDescricao()) != null){
            throw new ResourceAlreadyExistsException("Esse estado já existe");
        }
        Estado estado = findById(id);
        estadoNovo.setId(estado.getId());
        mapper.map(estadoNovo,estado);
        return repository.save(estado);
    }

}
