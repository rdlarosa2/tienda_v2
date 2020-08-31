package com.farmatodo.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmatodo.tienda.dao.ProductoDAO;
import com.farmatodo.tienda.entity.Producto;



@Service
public class ProductoServiceImpl implements ProductoService {

	private ProductoDAO productoDAO;
	
	/* @Qualifier("employeeDAOJpaImpl")  */
	@Autowired
	public ProductoServiceImpl(ProductoDAO theProductoDAO) {
		productoDAO = theProductoDAO;
	}
	
	@Override
	@Transactional
	public Producto findById(int theId) {
		return productoDAO.findById(theId);
	}
	
	@Override
	@Transactional	
	public List<Producto> findAll() {
		return productoDAO.findAll();		
	}
	
	@Override
	@Transactional
	public void save(Producto theProducto) {
		productoDAO.save(theProducto);
	}	
	
	@Override
	@Transactional	
	public void deleteById(int theId) {
		productoDAO.deleteById(theId);		
	}
	
	@Override
	@Transactional		
	public void marcarProductosComoVendidos(List<Producto> productos) {
		for (Producto prod: productos) {
			prod.setEstado("VENDIDO");
			save(prod);
		}
		
	}	
}
