package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Obrigatório informar a descricao")
    @Column(unique = true)
    private String descricao;

    @NotNull(message = "Obrigatório informar o país")
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

}
