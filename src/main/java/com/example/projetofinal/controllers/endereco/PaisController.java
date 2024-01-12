package com.example.projetofinal.controllers.endereco;

import com.example.projetofinal.entities.endereco.Pais;
import com.example.projetofinal.services.endereco.PaisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco/pais")
@RequiredArgsConstructor
public class PaisController {

    private final PaisService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid Pais pais){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pais));
    }
    @GetMapping
    public ResponseEntity<List<Pais>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id,@RequestBody @Valid Pais pais){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,pais));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
