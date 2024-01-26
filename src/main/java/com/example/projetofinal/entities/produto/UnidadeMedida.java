package com.example.projetofinal.entities.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
public class UnidadeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    @NotBlank(message = "Obrigatório informar a descrição")
    private String descricao;
    
    @Column(unique = true)
    @NotBlank(message = "Obrigatório informar a sigla")
    private String sigla;

}