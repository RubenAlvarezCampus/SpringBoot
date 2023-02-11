package com.RubenA.GestorTareas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "index";
	}
	
	@PostMapping("/login")
	public String loginr(Model model,@ModelAttribute("usuario") Usuario user) {
		
		List<Usuario> usuarios = service.lista();
		
		//Comprobamos si es el admin
		if (user.getNombre().equals(usuarios.get(0).getNombre()) && user.getPassword().equals(usuarios.get(0).getPassword())) {
			return "redirect:/admin";
		}
		
		//Comprobamos si es otro usuario
		for (Usuario usuario : usuarios) {
			if (user.getNombre().equals(usuario.getNombre()) && user.getPassword().equals(usuario.getPassword())) {
				return "redirect:/tareas/user/"+usuario.getId_usuario();
			}
		}
		
		//Si no coinciden los datos con la BBDD te devuelve al index
		return "redirect:/";
	}
	
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
		return "redirect:/admin";
	}
	
	@PostMapping("/admin/save")
	public String save(@Validated Usuario user, Model model) {
		service.save(user);
		return "redirect:/admin";
	}
	
	@GetMapping("/tareas/{cuenta}/{id}")
	public String listar_tarea (@PathVariable String cuenta,@PathVariable int id,Model model) {
		List<Tarea> tareas = service_t.lista();
		model.addAttribute("tareas",tareas);
		model.addAttribute("ID",id);
		model.addAttribute("cuenta",cuenta);
		return "tareas";
	}
	
	@GetMapping("/tareas/add/{cuenta}/{id}")
	public String agregar_tarea (@PathVariable String cuenta,@PathVariable int id,Model model) {
		model.addAttribute("tarea",new Tarea(0,"Pendiente",null,id));
		model.addAttribute("ID",id);
		model.addAttribute("cuenta",cuenta);
		return "tareas_add";
	}
	
	@GetMapping("/tareas/update/{cuenta}/{id_t}")
	public String editar_tarea(@PathVariable String cuenta,@PathVariable int id_t, Model model) {
		Optional<Tarea>tarea=service_t.listarId(id_t);
		model.addAttribute("tarea",tarea);
		model.addAttribute("cuenta",cuenta);
		return "tareas_update";
	}
	
	@GetMapping("/tareas/delete/{id}")
	public String eliminar_tarea(@PathVariable int id, Model model) {
		service_t.delete(id);
		return "redirect:/tareas";
	}
	
	@PostMapping("/tareas/save/{cuenta}")
	public String save(@PathVariable String cuenta, @Validated Tarea tarea) {
		service_t.save(tarea);
		return "redirect:/tareas/"+cuenta+"/"+tarea.getId_usuario();
	}
}
