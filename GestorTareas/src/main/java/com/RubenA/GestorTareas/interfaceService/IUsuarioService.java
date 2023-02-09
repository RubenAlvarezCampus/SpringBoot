package com.RubenA.GestorTareas.interfaceService;

import java.util.List;
import java.util.Optional;

import com.RubenA.GestorTareas.modelo.Usuario;

public interface IUsuarioService {
	public List<Usuario>lista();
	public Optional<Usuario>listarId(int id);
	public int save(Usuario u);
	public void delete (int id);
}
