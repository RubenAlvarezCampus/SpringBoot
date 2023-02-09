package com.RubenAlvarez.HitoIndividualAccesoDatos.modelo;

import java.util.ArrayList;


public class Usuario {
	private int id_usuario;
	private String nombre;
	private String password;
	private ArrayList<Tarea> tareas;
	
	//Constructor
	public Usuario() {}

	public Usuario(int id_usuario, String name, String password, ArrayList<Tarea> tareas) {
		this.id_usuario = id_usuario;
		this.nombre = name;
		this.password = password;
		this.tareas = tareas;
	}
	
	//Get y Set
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
	
}
