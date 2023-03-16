package com.RubenA.EvidenciaP.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RubenA.EvidenciaP.modelo.Categoria;

@Repository
public interface ICategoria extends CrudRepository<Categoria, Integer>{

}
