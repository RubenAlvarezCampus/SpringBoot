package com.RubenAlvarez.HitoIndividualAccesoDatos.modelo;

public class Tarea {
	private int id_tarea;
	private String estado;
	private String nombre;
	private int id_usuario;
	
	//Constructor
	public Tarea() {
		super();
	}

	public Tarea(int id_tarea, String estado, String nombre, int id_usuario) {
		super();
		this.id_tarea = id_tarea;
		this.estado = estado;
		this.nombre = nombre;
		this.id_usuario = id_usuario;
	}

	//Get y set 
	public int getId_Tarea() {
		return id_tarea;
	}

	public void setId_Tarea(int id_Tarea) {
		this.id_tarea = id_Tarea;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
