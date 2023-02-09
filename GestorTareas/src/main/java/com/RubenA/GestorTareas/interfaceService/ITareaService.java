package com.RubenA.GestorTareas.interfaceService;

import java.util.List;
import java.util.Optional;

import com.RubenA.GestorTareas.modelo.Tarea;
import com.RubenA.GestorTareas.modelo.Usuario;

public interface ITareaService {
	public List<Tarea>lista();
	public Optional<Tarea>listarId(int id);
	public int save(Tarea t);
	public void delete (int id);
}
