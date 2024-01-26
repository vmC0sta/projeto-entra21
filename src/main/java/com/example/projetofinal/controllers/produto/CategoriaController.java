package com.example.projetofinal.controllers.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetofinal.entities.produto.Categoria;
import com.example.projetofinal.repositories.produto.CategoriaRepository;
import com.example.projetofinal.services.produto.CategoriaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produto/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository repo;
	
	@Autowired
	CategoriaService service;
	
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoria));
    }
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody @Valid Categoria categoria){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,categoria));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
