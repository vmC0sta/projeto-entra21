package com.example.projetofinal.entities.pessoa;

import com.example.projetofinal.validation.group.pessoa.CnpjGroup;
import com.example.projetofinal.validation.group.pessoa.CpfGroup;

public enum TipoPessoa {
    JURIDICA("Jurídica", CnpjGroup.class),
    FISICA("Física", CpfGroup.class);

    String descricao;
    Class<?> group;

    TipoPessoa(String descricao,Class<?> group) {
        this.descricao = descricao;
        this.group = group;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Class<?> getGroup() {
        return group;
    }

}
