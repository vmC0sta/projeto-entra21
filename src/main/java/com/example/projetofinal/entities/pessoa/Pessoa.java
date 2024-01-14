package com.example.projetofinal.entities.pessoa;

import com.example.projetofinal.entities.endereco.Endereco;
import com.example.projetofinal.validation.group.pessoa.CnpjGroup;
import com.example.projetofinal.validation.group.pessoa.CpfGroup;
import com.example.projetofinal.validation.group.pessoa.PessoaGroupSequenceProvider;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;


@GroupSequenceProvider(PessoaGroupSequenceProvider.class)
@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Obrigatório informar o nome")
    @Column(unique = true)
    private String nome;

    @NotNull(message = "Obrigatório informar o tipo (JURIDICA/FISICA)")
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @NotNull(message = "Obrigatório informar a identificação")
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    @Column(unique = true, nullable = false)
    private String identificacao;

    private String telefone;

    @NotBlank(message = "Obrigatório informar o celular")
    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    @NotNull(message = "Obrigatório informar a categoria (CLIENTE/FUNCIONARIO) ")
    private CategoriaPessoa categoriaPessoa;

    @ManyToOne
    @NotNull(message = "Obrigatório informar o endereço")
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @Email
    @NotBlank(message = "Obrigatório informar o e-mail")
    @Column(nullable = false)
    private String email;

    private String infoComplementar;

}
