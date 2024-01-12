package com.example.projetofinal.services.endereco;

import com.example.projetofinal.entities.endereco.Pais;
import com.example.projetofinal.exceptions.ResourceAlreadyExistsException;
import com.example.projetofinal.exceptions.ResourceNotFoundException;
import com.example.projetofinal.repositories.endereco.PaisRepository;
import com.example.projetofinal.services.Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class PaisService implements Service<Pais> {

    private final PaisRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Pais> findAll() {
        return repository.findAll();
    }

    @Override
    public Pais findById(Long id) {
        Optional<Pais> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("País", "id", id));
    }


    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public Pais save(Pais pais) {
        if (repository.findByDescricao(pais.getDescricao()) != null)
            throw new ResourceAlreadyExistsException("Esse país já existe");
        return repository.save(pais);
    }

    @Override
    public Pais update(Long id, Pais paisNovo) {
        if (repository.findByDescricao(paisNovo.getDescricao()) != null)
            throw new ResourceAlreadyExistsException("Esse país já existe");
        Pais pais = findById(id);
        paisNovo.setId(pais.getId());
        mapper.map(paisNovo, pais);
        return repository.save(pais);
    }
}
