package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;
    @OneToMany(mappedBy = "municipio")
    private List<Bairro> bairro;
}
