package com.RubenA.EvidenciaP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RubenA.EvidenciaP.interfaceService.IUsuarioService;
import com.RubenA.EvidenciaP.interfaces.IUsuario;
import com.RubenA.EvidenciaP.modelo.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuario data;
	
	@Override
	public List<Usuario> lista() {
		return (List<Usuario>) data.findAll();
	}
	
}
