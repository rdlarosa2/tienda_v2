package com.farmatodo.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmatodo.tienda.dao.ClienteDAO;
import com.farmatodo.tienda.entity.Cliente;
import com.farmatodo.tienda.exception.ClaveInvalidaException;
import com.farmatodo.tienda.exception.UsuarioNoExisteException;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteDAO clienteDAO ;
	
	@Autowired
	public ClienteServiceImpl(ClienteDAO unClienteDAO) {
		clienteDAO = unClienteDAO ;
	}
	
	@Override
	@Transactional
	public void crear(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDAO.crear(cliente);
	}

	@Override
	@Transactional	
	public Cliente autenticarUsuario(String unUsuario, String password) throws UsuarioNoExisteException, ClaveInvalidaException {
	   Cliente cliente = null ;
	   try {
	      cliente = clienteDAO.findByUsuario(unUsuario);
	      
	      if ( ! clienteDAO.verifyUsuarioAndPassword(unUsuario,password) ) {
	    	  throw new ClaveInvalidaException();
	      }
	   }
	   catch (UsuarioNoExisteException une) {
		   throw une;
	   }
	   return cliente;
	}	
	
	@Override
	@Transactional
	public void deleteByUsuario(String unUsuario) {
		clienteDAO.deleteByUsuario(unUsuario);
	}	
}
