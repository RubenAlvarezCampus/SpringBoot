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

import com.RubenA.GestorTareas.interfaceService.ITareaService;
import com.RubenA.GestorTareas.interfaceService.IUsuarioService;
import com.RubenA.GestorTareas.modelo.Tarea;
import com.RubenA.GestorTareas.modelo.Usuario;



@Controller
@RequestMapping
public class HomeController {
	
	@Autowired
	private IUsuarioService service;
	@Autowired
	private ITareaService service_t;
	
	@GetMapping("/admin")
	public String listar(Model model) {
		List<Usuario> usuarios = service.lista();
		model.addAttribute("usuarios",usuarios);
		return "usuarios";
	}
	
	@GetMapping("/admin/add")
	public String agregar(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "add";
	}
	
	@GetMapping("/admin/update/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Usuario>usuario=service.listarId(id);
		model.addAttribute("usuario",usuario);
		return "update";
	}
	
	@GetMapping("/admin/delete/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/admin/usuarios";
	}
	
	@PostMapping("/admin/save")
	public String save(@Validated Usuario user, Model model) {
		service.save(user);
		return "redirect:/admin";
	}
	
	@GetMapping("/tareas/{id}")
	public String listar_tarea (@PathVariable int id,Model model) {
		List<Tarea> tareas = service_t.lista();
		model.addAttribute("tareas",tareas);
		model.addAttribute("ID",id);
		return "tareas";
	}
	
	@GetMapping("/tareas/add/{id}")
	public String agregar_tarea (@PathVariable int id,Model model) {
		model.addAttribute("tarea",new Tarea(0, "pendiente", null, id));
		model.addAttribute("ID",id);
		return "tareas_add";
	}
	
	@GetMapping("/tareas/update/{id_t}")
	public String editar_tarea(@PathVariable int id_t, Model model) {
		Optional<Tarea>tarea=service_t.listarId(id_t);
		model.addAttribute("tarea",tarea);
		return "tareas_update";
	}
	
	@PostMapping("/tareas/save")
	public String save(@Validated Tarea tarea) {
		service_t.save(tarea);
		return "redirect:/tareas/"+tarea.getId_usuario();
	}
}
