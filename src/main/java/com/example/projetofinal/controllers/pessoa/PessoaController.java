package com.example.projetofinal.controllers.pessoa;

import com.example.projetofinal.entities.pessoa.Pessoa;
import com.example.projetofinal.services.pessoa.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pessoa/pessoa")
public class PessoaController {

    private final PessoaService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pessoa));
    }
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody @Valid Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,pessoa));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
