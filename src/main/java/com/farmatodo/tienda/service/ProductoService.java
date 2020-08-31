package com.farmatodo.tienda.service;

import java.util.List;

import com.farmatodo.tienda.entity.Producto;

public interface ProductoService {

	public Producto findById(int theId);
	public List<Producto> findAll();	
	public void save(Producto theProducto);
	public void deleteById(int theId);
	
	public void marcarProductosComoVendidos(List<Producto> productos); 
}
