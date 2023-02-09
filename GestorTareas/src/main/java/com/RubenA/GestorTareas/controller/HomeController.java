package com.RubenA.GestorTareas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.RubenA.GestorTareas.interfaceService.IUsuarioService;
import com.RubenA.GestorTareas.modelo.Usuario;



@Controller
@RequestMapping
public class HomeController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/admin/usuarios")
	public String listar(Model model) {
		List<Usuario> usuarios = service.lista();
		model.addAttribute("usuarios",usuarios);
		return "usuarios";
	}
	
	@GetMapping("/add")
	public String agregar(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "add";
	}
	
	@GetMapping("/update/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Usuario>usuario=service.listarId(id);
		model.addAttribute("usuario",usuario);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/admin/usuarios";
	}
	
	@PostMapping("/save")
	public String save(@Validated Usuario user, Model model) {
		service.save(user);
		return "redirect:/admin/usuarios";
	}
}
