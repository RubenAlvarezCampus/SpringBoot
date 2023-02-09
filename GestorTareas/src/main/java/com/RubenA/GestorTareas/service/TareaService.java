package com.RubenA.GestorTareas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RubenA.GestorTareas.interfaceService.ITareaService;
import com.RubenA.GestorTareas.interfaces.ITarea;
import com.RubenA.GestorTareas.modelo.Tarea;

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
		return Optional.empty();
	}

	@Override
	public int save(Tarea t) {
		return 0;
	}

	@Override
	public void delete(int id) {
		
	}

}
