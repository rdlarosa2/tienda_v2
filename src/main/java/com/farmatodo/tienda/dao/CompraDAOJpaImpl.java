package com.farmatodo.tienda.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmatodo.tienda.entity.Compra;
import com.farmatodo.tienda.entity.Producto;

@Repository
public class CompraDAOJpaImpl implements CompraDAO {
	private EntityManager entityManager;
	
	@Autowired
	public CompraDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public void save(Compra unaCompra) {

		// save or update the employee
		Compra dbCompra = entityManager.merge(unaCompra);
		
		// update with id from db ... so we can get generated id for save/insert
		unaCompra.setIdCompra(dbCompra.getIdCompra());	
	}

}
