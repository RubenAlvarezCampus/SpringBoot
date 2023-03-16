package com.RubenA.EvidenciaP.controller;


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

import com.RubenA.EvidenciaP.interfaceService.IProductoService;
import com.RubenA.EvidenciaP.interfaceService.IUsuarioService;
import com.RubenA.EvidenciaP.modelo.Producto;
import com.RubenA.EvidenciaP.modelo.Usuario;

@Controller
@RequestMapping
public class HomeController {
	
	@Autowired
	private IProductoService service_p;
	@Autowired
	private IUsuarioService service_u;
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("usuario",new Usuario());
		List<Producto> Productos = service_p.lista();
		model.addAttribute("productos",Productos);
		return "index";
	}
	
	@PostMapping("/login")
	public String loginr(Model model,@ModelAttribute("usuario") Usuario user) {
		
		List<Usuario> usuarios = service_u.lista();		
		
		//Comprobamos si es otro usuario
		for (Usuario usuario : usuarios) {
			if (user.getEmail().equals(usuario.getEmail()) && user.getPassword().equals(usuario.getPassword())) {
				if (usuario.getPermiso().equals("LECTOR")) {
					return "redirect:/user/lector/0";
				} else {
					return "redirect:/user/editor/0";
				}		
			}
		}
		
		//Si no coinciden los datos con la BBDD te devuelve al index
		return "redirect:/";
	}
	
	@GetMapping("/user/{cuenta}/{categoria}")
	public String mostrar (@PathVariable String cuenta,@PathVariable int categoria, Model model) {
		List<Producto> Productos = service_p.lista();
		model.addAttribute("productos",Productos);
		model.addAttribute("categoria",categoria);
		model.addAttribute("cuenta",cuenta);
		return "usuario";
	}
	
	@GetMapping("/user/update/{cuenta}/{id}")
	public String editar_producto(@PathVariable String cuenta,@PathVariable int id, Model model) {
		Optional<Producto>producto=service_p.listarId(id);
		model.addAttribute("producto",producto);
		model.addAttribute("cuenta",cuenta);
		return "update";
	}
	
	@PostMapping("/user/save/{cuenta}")
	public String save(@PathVariable String cuenta, @Validated Producto producto) {
		service_p.save(producto);
		return "redirect:/user/"+cuenta+"/0";
	}
}
