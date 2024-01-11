package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cep_id", nullable = false)
    private Cep cep;

    @Column
    private String numero;

    @Column
    private String complemento;

    @Column
    private String logradouro;

}
