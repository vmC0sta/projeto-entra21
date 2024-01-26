package com.example.projetofinal.services.produto;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.projetofinal.entities.produto.Categoria;
import com.example.projetofinal.exceptions.ResourceAlreadyExistsException;
import com.example.projetofinal.exceptions.ResourceNotFoundException;
import com.example.projetofinal.repositories.produto.CategoriaRepository;
import com.example.projetofinal.services.Service;

public class CategoriaService implements Service<Categoria>{

	@Autowired
	CategoriaRepository repo;
	
	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Categoria findById(Long id) {
        Optional<Categoria> optional = repo.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("categoria", "id", id));
	}

	@Override
	public void delete(Long id) {
		repo.delete(findById(id));
		
	}

	@Override
	public Categoria save(Categoria categoria) {
		if (repo.findByDescricao(categoria.getDescricao()) != null){
			throw new ResourceAlreadyExistsException("Essa categoria já existe");
		}
		return repo.save(categoria);
	}

	@Override
	public Categoria update(Long id, Categoria categoriaNova) {
		if (repo.findByDescricao(categoriaNova.getDescricao()) != null){
			throw new ResourceAlreadyExistsException("Essa categoria já existe");
		}
		Categoria categoria = findById(id);
		categoria.setDescricao(categoriaNova.getDescricao());
        return repo.save(categoria);
	}

}
