package com.example.projetofinal.entities.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bairro_id", nullable = false)
    private Bairro bairro;

    @NotBlank(message = "Obritório informar o número ou 'S/N' se não tiver número")
    private String numero;


    private String complemento;

    @NotBlank(message = "Obrigatório informar o logradouro")
    private String logradouro;
}
