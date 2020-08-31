package com.farmatodo.tienda.dao;

import java.util.List;

import com.farmatodo.tienda.entity.Producto;

public interface ProductoDAO {

	public Producto findById(int theId);
	public List<Producto> findAll();
	public void save(Producto theProducto);	
	public void deleteById(int theId);
}
