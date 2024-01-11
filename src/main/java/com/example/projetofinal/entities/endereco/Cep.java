package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Cep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "bairro_id", nullable = false)
    private Bairro bairro;
    @OneToMany(mappedBy = "cep")
    private List<Endereco> endereco;

}
