package com.RubenA.GestorTareas.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	private String nombre;
	private String password;	
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Tarea> tareas;
	
	//Constructor
	public Usuario() {}

	public Usuario(int id_usuario, String nombre, String password, List<Tarea> tareas) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(targetEntity=Tarea.class, mappedBy="id_usuario", fetch=FetchType.EAGER)
	public List<Tarea> getTareas() {
		return tareas;
	}
	
	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", password=" + password + ", tareas="
				+ tareas + "]";
	}
	
}
