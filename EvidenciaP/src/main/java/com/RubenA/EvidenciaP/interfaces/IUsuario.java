package com.RubenA.EvidenciaP.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RubenA.EvidenciaP.modelo.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer>{

}
