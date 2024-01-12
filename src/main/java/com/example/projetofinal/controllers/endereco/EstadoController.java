package com.example.projetofinal.controllers.endereco;

import com.example.projetofinal.entities.endereco.Estado;
import com.example.projetofinal.services.endereco.EstadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/endereco/estado")
public class EstadoController {
    private final EstadoService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid Estado estado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estado));
    }

    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Estado estado) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
