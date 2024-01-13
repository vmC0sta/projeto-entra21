package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

}
