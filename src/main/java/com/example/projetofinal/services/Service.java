package com.example.projetofinal.services;

import java.util.List;

public interface Service<T> {
     List<T> findAll();
     T findById(Long id);
     void delete(Long id);
     T save(T t);
     T update(Long id, T t);

}
