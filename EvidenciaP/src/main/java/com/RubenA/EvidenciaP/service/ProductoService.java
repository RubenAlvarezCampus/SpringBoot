package com.RubenA.EvidenciaP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RubenA.EvidenciaP.interfaceService.IProductoService;
import com.RubenA.EvidenciaP.interfaces.IProducto;
import com.RubenA.EvidenciaP.modelo.Producto;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProducto data;
	
	@Override
	public List<Producto> lista() {
		return (List<Producto>) data.findAll();
	}

	@Override
	public Optional<Producto> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Producto p) {
		int res = 0;
		Producto producto_save = data.save(p);
		
		if (!producto_save.equals(null)) {
			res=1;
		}
		return 0;
	}
}
