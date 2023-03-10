package com.campusfp.empleos.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.campusfp.empleos.modelo.Vacante;

@Controller
public class HomeController {

	@GetMapping("/")
	public String inicio() {
		return "index";
	}

	@GetMapping("/listado")
	public String listado(Model model) {

		List<Vacante> lista = new LinkedList<Vacante>();
		lista = listaVacantes();

		model.addAttribute("listadovacantes", lista);
		
		return "listado";
	}

	@GetMapping("/detalle")
	public String detalle(Model model) {
		model.addAttribute("mensaje", "Hola desde el modelo");
		model.addAttribute("fecha", new Date());

		String nombre = "Programador PA";
		Date fPublicacion = new Date();
		double salario = 1800.000;
		boolean vigente = true;

		model.addAttribute("nombre", nombre);
		model.addAttribute("fpublicacion", fPublicacion);
		model.addAttribute("salarioOfertado", salario);
		model.addAttribute("estaVigente", vigente);

		return "detalle";
	}
	public List<Vacante> listaVacantes(){
		
		List<Vacante> lista = new LinkedList<Vacante>();
		
		Vacante v1 = new Vacante(1,"Ingeniero Informático", "asdfasdfasd", new Date(),24000,"s");
		Vacante v2 = new Vacante(2,"Desarrollador Back-End ", "asdfasdfasd", new Date(),24000,"n");
		Vacante v3 = new Vacante(3,"Desarrollador Front-End ", "asdfasdfasd", new Date(),24000,"s");
		Vacante v4 = new Vacante(4,"Maquetador Web", "asdfasdfasd", new Date(),24000,"s");
		
		v1.setLogo("logo.jfif");
		v2.setLogo("LogoTFG.png");
		v3.setLogo("beard.jfif");
		
		lista.add(v1);
		lista.add(v2);
		lista.add(v3);
		lista.add(v4);
		return lista;
	}
}