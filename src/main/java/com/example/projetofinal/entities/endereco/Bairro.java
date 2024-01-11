package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "municipio_id", nullable = false)
    private Municipio municipio;

    @OneToMany(mappedBy = "bairro")
    private List<Cep> cep;
}
