package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank( message = "Obrigatório informar a descrição")
    @Column(unique = true)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "municipio_id", nullable = false)
    private Municipio municipio;

}
