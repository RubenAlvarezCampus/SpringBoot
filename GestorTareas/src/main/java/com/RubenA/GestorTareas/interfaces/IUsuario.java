package com.RubenA.GestorTareas.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RubenA.GestorTareas.modelo.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer>{

}
