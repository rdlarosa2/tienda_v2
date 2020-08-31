package com.farmatodo.tienda.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmatodo.tienda.dao.TiendaDAO;
import com.farmatodo.tienda.entity.Producto;
import com.farmatodo.tienda.entity.Tienda;

@Service
public class TiendaServiceImpl implements TiendaService {

	private TiendaDAO tiendaDAO;
	
	@Autowired
	public TiendaServiceImpl(TiendaDAO theTiendaDAO) {
		tiendaDAO = theTiendaDAO;
	}	
	
	@Override
	@Transactional	
	public Tienda findById(int theId) {

		return tiendaDAO.findById(theId);
	}

	@Override
	@Transactional	
	public List<Tienda> findAll() {

		return tiendaDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Tienda theTienda) {
		tiendaDAO.save(theTienda);
	}

	@Override
	@Transactional	
	public void deleteById(int theId) {
		tiendaDAO.deleteById(theId);
	}

	public List<Producto> productosExistentes(int idTienda, Collection<Integer> idProductos) {
		return tiendaDAO.productosExistentes(idTienda, idProductos); 
	}	
}
