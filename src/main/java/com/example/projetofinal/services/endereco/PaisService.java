package com.example.projetofinal.services.endereco;

import com.example.projetofinal.entities.endereco.Pais;
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

    private final  PaisRepository repository;
    private final  ModelMapper mapper;

    @Override
    public List<Pais> consultar() {
       return repository.findAll();
    }

    @Override
    public Pais consultarPorId(Long id) {
        Optional<Pais> optional = repository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("País:","id",id));
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
