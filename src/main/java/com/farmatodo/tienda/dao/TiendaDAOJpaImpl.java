package com.farmatodo.tienda.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmatodo.tienda.entity.Producto;
import com.farmatodo.tienda.entity.Tienda;

@Repository
public class TiendaDAOJpaImpl implements TiendaDAO {

	private EntityManager entityManager;
	
	@Autowired
	public TiendaDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public Tienda findById(int theId) {
		Tienda laTienda = entityManager.find(Tienda.class, theId );
		
		List<Producto> prodsDisponibles = new ArrayList<Producto>();
		
		
		/* Ahora vamos a obtener solo los productos de la tienda cuyo estado es DISPONIBLE */
		
		Collection<Producto> lstProductos = laTienda.getProductos();
		
		for (Producto prod: lstProductos ) {
			if (prod.getEstado().equals("DISPONIBLE") ) {
				prodsDisponibles.add(prod);
			}
		}
		laTienda.setProductos(prodsDisponibles);
		
		return laTienda;
	}

	@Override
	public List<Tienda> findAll() {
		// create a query
		Query theQuery = 
				entityManager.createQuery("from Tienda");
		
		// execute query and get result list
		List<Tienda> tiendas = theQuery.getResultList();
		
		// return the results		
		return tiendas;
	}

	@Override
	public void save(Tienda theTienda) {

		// save or update the employee
		Tienda dbTienda = entityManager.merge(theTienda);
		
		// update with id from db ... so we can get generated id for save/insert
		theTienda.setIdTienda(dbTienda.getIdTienda());	
	
	}

	@Override
	public void deleteById(int theId) {

		// delete object with primary key
		Query theQuery = entityManager.createQuery(
							"delete from Tienda where id=:tiendaId");
		
		theQuery.setParameter("tiendaId", theId);
		
		theQuery.executeUpdate();		
	}
	
	@Override	
	public List<Producto> productosExistentes(int idTienda, Collection<Integer> idProductos) {
		List<Producto> valRetorno = new ArrayList<Producto>() ;
		Tienda tienda = findById(idTienda);
		
		Collection<Producto> prodsTienda = tienda.getProductos();
		
		for (Integer idProd: idProductos) {
			
		   for (Producto prod : prodsTienda) {
			   
			   if ( idProd.intValue()==prod.getId() ) {
				   /* El producto con id idProd lo tiene esta tienda idTienda*/
				   valRetorno.add(prod);
				   break;
			   }
		   }
		}
		
		return  valRetorno;
	}
}
