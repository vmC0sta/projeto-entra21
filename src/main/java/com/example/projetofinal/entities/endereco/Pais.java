package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String descricao;

}
