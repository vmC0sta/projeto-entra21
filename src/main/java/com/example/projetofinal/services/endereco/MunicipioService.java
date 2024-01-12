package com.example.projetofinal.services.endereco;

import com.example.projetofinal.entities.endereco.Municipio;
import com.example.projetofinal.exceptions.ResourceAlreadyExistsException;
import com.example.projetofinal.exceptions.ResourceNotFoundException;
import com.example.projetofinal.repositories.endereco.MunicipioRepository;
import com.example.projetofinal.services.Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class MunicipioService implements Service<Municipio> {

    private final MunicipioRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Municipio> findAll() {
        return repository.findAll();
    }

    @Override
    public Municipio findById(Long id) {
        Optional<Municipio> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("Município", "id", id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public Municipio save(Municipio municipio) {
        if (repository.findByDescricao(municipio.getDescricao()) != null) {
            throw new ResourceAlreadyExistsException("Esse múnicipio já existe");
        }

        return repository.save(municipio);

    }

    @Override
    public Municipio update(Long id, Municipio municipioNovo) {
        if (repository.findByDescricao(municipioNovo.getDescricao()) != null) {
            throw new ResourceAlreadyExistsException("Esse município já existe");
        }

        Municipio municipio = findById(id);
        municipioNovo.setId(municipio.getId());
        mapper.map(municipioNovo, municipio);
        return repository.save(municipio);
    }
}
