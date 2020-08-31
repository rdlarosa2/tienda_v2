package com.farmatodo.tienda.service;

import java.util.Collection;
import java.util.List;

import com.farmatodo.tienda.entity.Producto;
import com.farmatodo.tienda.entity.Tienda;

public interface TiendaService {
	public Tienda findById(int theId);
	public List<Tienda> findAll();	
	public void save(Tienda theTienda);
	public void deleteById(int theId);
	public List<Producto> productosExistentes(int idTienda, Collection<Integer> idProductos);	
}
