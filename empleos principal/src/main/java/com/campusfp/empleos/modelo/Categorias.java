package com.campusfp.empleos.modelo;

public class Categorias {
	private Integer id;
    private String categoria;
    private Integer activa = 1;
    
    public Categorias(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getActiva() {
        return activa;
    }
    public void setActiva(int activa) {
        this.activa = activa;
    }
    @Override
    public String toString() {
        return "Categorias [id=" + id + ", categoria=" + categoria + ", activa=" + activa + "]";
    }
}
