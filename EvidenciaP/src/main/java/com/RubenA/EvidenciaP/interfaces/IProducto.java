package com.RubenA.EvidenciaP.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RubenA.EvidenciaP.modelo.Producto;

@Repository
public interface IProducto extends CrudRepository<Producto, Integer>{

}
