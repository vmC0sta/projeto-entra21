package com.example.projetofinal.controllers.endereco;

import com.example.projetofinal.entities.endereco.Cep;
import com.example.projetofinal.services.endereco.CepService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/endereco/cep")
public class CepController {
    private final CepService service;

    @PostMapping
    public ResponseEntity<Cep> save(@RequestBody @Valid Cep cep){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cep));
    }
    @GetMapping
    public ResponseEntity<List<Cep>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody @Valid Cep cep){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,cep));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
