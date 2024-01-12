package com.example.projetofinal.services;

import java.util.List;

public interface Service<T> {
     List<T> consultar();
     T consultarPorId(Long id);
     void excluir(Long id);
     T salvar(T t);
     T alterar(Long id, T t);

}
