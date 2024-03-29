package com.RubenA.EvidenciaP.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproducto;

	private String medida;

	private String nombre;

	private int precio;

	private int stock;

	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria categoria;

	public Producto() {
	}

	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getMedida() {
		return this.medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}