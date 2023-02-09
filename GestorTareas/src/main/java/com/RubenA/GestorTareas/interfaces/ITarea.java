package com.RubenA.GestorTareas.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.RubenA.GestorTareas.modelo.Tarea;

@Repository
public interface ITarea extends CrudRepository<Tarea, Integer>{

}
