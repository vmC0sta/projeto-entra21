package com.example.projetofinal.service;

import java.util.List;

public interface Service<T> {
    public List<T> consultar();
    public T consultarPorId(Long id);
    public void excluir(Long id);
    public T salvar(T t);
    public T alterar(Long id, T t);

}
