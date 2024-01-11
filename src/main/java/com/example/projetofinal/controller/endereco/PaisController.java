package com.example.projetofinal.controller.endereco;

import com.example.projetofinal.entities.endereco.Pais;
import com.example.projetofinal.service.endereco.PaisService;
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
    public ResponseEntity<Object> salvar(@RequestBody Pais pais){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(pais));
    }
    @GetMapping
    public ResponseEntity<List<Pais>> consultar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.consultar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> consultarPorID(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.consultarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@PathVariable Long id,@RequestBody Pais pais){
        return ResponseEntity.status(HttpStatus.OK).body(service.alterar(id,pais));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
