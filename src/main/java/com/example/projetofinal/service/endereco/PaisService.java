package com.example.projetofinal.service.endereco;

import com.example.projetofinal.entities.endereco.Pais;
import com.example.projetofinal.repository.endereco.PaisRepository;
import com.example.projetofinal.service.Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class PaisService implements Service<Pais> {

    private final  PaisRepository repository;
    private final  ModelMapper mapper;

    @Override
    public List<Pais> consultar() {
       return repository.findAll();
    }

    @Override
    public Pais consultarPorId(Long id) {
        Optional<Pais> optional = repository.findById(id);
        return optional.orElseThrow(() -> new EntityNotFoundException("Contato não encontrado"));
    }

    @Override
    public void excluir(Long id) {
        repository.delete(consultarPorId(id)) ;
    }

    @Override
    public Pais salvar(Pais pais) {
       return  repository.save(pais);
    }

    @Override
    public Pais alterar(Long id, Pais paisNovo) {
        Pais pais = consultarPorId(id);
        paisNovo.setId(pais.getId());
        mapper.map(paisNovo, pais);
        return repository.save(pais);
    }
}
