package com.RubenAlvarez.HitoIndividualAccesoDatos.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.RubenAlvarez.HitoIndividualAccesoDatos.modelo.Usuario;

public class HomeController {
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("Usuario",new Usuario());
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginr(Model model,@ModelAttribute("Usuario") Usuario user) {
		if (user.getName().equals("Admin") && user.getPassword().equals("root")) {
			return "admin";
		}
		else {
			//BBDD autentificacion
		}
		return "index";
	}
}
