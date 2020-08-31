package com.farmatodo.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmatodo.tienda.entity.Producto;

@Repository
public class ProductoDAOJpaImpl implements ProductoDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ProductoDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public Producto findById(int theId) {
		Integer idProducto = new Integer(theId);
		Producto elProducto = entityManager.find(Producto.class, idProducto );    
		return elProducto;  
	}
	
	@Override
	public List<Producto> findAll() {

		// create a query
		Query theQuery = 
				entityManager.createQuery("from Producto");
		
		// execute query and get result list
		List<Producto> productos = theQuery.getResultList();
		
		// return the results		
		return productos;
	}

	@Override
	public void save(Producto theProducto) {

		// crear o actualizar el producto
		Producto dbProducto = entityManager.merge(theProducto);
		
		// update with id from db ... so we can get generated id for save/insert
		theProducto.setId(dbProducto.getId());	
	}
	
	@Override
	public void deleteById(int theId) {

		// delete object with primary key
		Query theQuery = entityManager.createQuery(
							"delete from Producto where id=:productoId");
		
		theQuery.setParameter("productoId", theId);
		
		theQuery.executeUpdate();
	}
	
}
