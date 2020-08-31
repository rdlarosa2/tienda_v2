package com.farmatodo.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmatodo.tienda.dao.CompraDAO;
import com.farmatodo.tienda.entity.Compra;

@Service
public class CompraServiceImpl implements CompraService {

	private CompraDAO compraDAO ;
	
	@Autowired
	public CompraServiceImpl(CompraDAO unCompraDAO) {
		compraDAO = unCompraDAO;
	}
	
	
	@Override
	@Transactional
	public void save(Compra unaCompra) {
		compraDAO.save(unaCompra);
	}

}
