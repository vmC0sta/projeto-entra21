package com.example.projetofinal.entities.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    @NotBlank(message = "Obrigatório informar a descrição")
    private String descricao;

}