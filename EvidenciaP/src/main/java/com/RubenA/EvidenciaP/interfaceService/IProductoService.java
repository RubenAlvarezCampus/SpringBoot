package com.RubenA.EvidenciaP.interfaceService;

import java.util.List;
import java.util.Optional;

import com.RubenA.EvidenciaP.modelo.Categoria;
import com.RubenA.EvidenciaP.modelo.Producto;

public interface IProductoService {
	public List<Producto>lista();
	public Optional<Producto>listarId(int id);
	public int save(Producto u);
}
