package com.RubenA.GestorTareas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RubenA.GestorTareas.interfaceService.IUsuarioService;
import com.RubenA.GestorTareas.interfaces.IUsuario;
import com.RubenA.GestorTareas.modelo.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuario data;
	
	@Override
	public List<Usuario> lista() {
		return (List<Usuario>) data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Usuario user) {
		int res = 0;
		Usuario user_save = data.save(user);
		
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
