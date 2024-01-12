package com.example.projetofinal.controllers.endereco;

import com.example.projetofinal.entities.endereco.Bairro;
import com.example.projetofinal.services.endereco.BairroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/endereco/bairro")
public class BairroController {

    private final BairroService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid Bairro bairro){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(bairro));
    }
    @GetMapping
    public ResponseEntity<List<Bairro>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Bairro bairro){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,bairro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
