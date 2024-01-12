package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    @NotBlank(message = "O campo descrição não pode estar em branco")
    private String descricao;

}
