package com.RubenA.GestorTareas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RubenA.GestorTareas.interfaceService.ITareaService;
import com.RubenA.GestorTareas.interfaces.ITarea;
import com.RubenA.GestorTareas.modelo.Tarea;
import com.RubenA.GestorTareas.modelo.Usuario;

@Service
public class TareaService implements ITareaService{

	@Autowired
	private ITarea data;
	
	@Override
	public List<Tarea> lista() {
		return (List<Tarea>) data.findAll();
	}

	@Override
	public Optional<Tarea> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Tarea t) {
		int res = 0;
		Tarea user_save = data.save(t);
		
		if (!user_save.equals(null)) {
			res=1;
		}
		return 0;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
