package com.farmatodo.tienda.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmatodo.tienda.entity.Cliente;
import com.farmatodo.tienda.entity.Producto;
import com.farmatodo.tienda.exception.UsuarioNoExisteException;

@Repository
public class ClienteDAOJpaImpl implements ClienteDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ClienteDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public void crear(Cliente theCliente) {
		// crear o actualizar el cliente
		Cliente dbCliente = entityManager.merge(theCliente);
		
		// update with id from db ... so we can get generated id for save/insert
		theCliente.setIdCliente(dbCliente.getIdCliente()  ); /*.getId()*/ 			
	}

	@Override
	public Cliente findByUsuario(String unUsuario) throws UsuarioNoExisteException {
		Cliente cliente = null ;
		// create a query
		Query theQuery = 
				entityManager.createQuery("from Cliente where usuario = :usuario ");

		theQuery.setParameter("usuario", unUsuario);		
		try {
		   cliente = (Cliente)theQuery.getSingleResult();
		}
		catch (NoResultException nre) {
		   throw new UsuarioNoExisteException();	
		}
		return cliente;  
	}
	
	@Override	
	public boolean verifyUsuarioAndPassword(String unUsuario, String unPassword) {
		boolean valRetorno = false ;
		Cliente cliente = null ;
		// create a query
		Query theQuery = 
				entityManager.createQuery("from Cliente where usuario = :usuario and contrasegna = :contrasegna");

		theQuery.setParameter("usuario", unUsuario);		// contrasegna
		theQuery.setParameter("contrasegna", unPassword);
		try {
		   cliente = (Cliente)theQuery.getSingleResult();
		}
		catch (NoResultException nreExc) {
		   return false ;	
		}
		valRetorno = (cliente!=null) ;
		return valRetorno; 
	}
	
	@Override	
	public void deleteByUsuario(String unUsuario) {
		Query theQuery = entityManager.createQuery(
				"delete from Cliente where usuario = :usuario");

		theQuery.setParameter("usuario", unUsuario);

		theQuery.executeUpdate();		
	}	
}
