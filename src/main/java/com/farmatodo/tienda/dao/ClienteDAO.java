package com.farmatodo.tienda.dao;

import com.farmatodo.tienda.entity.Cliente;
import com.farmatodo.tienda.exception.UsuarioNoExisteException;

public interface ClienteDAO {

	public void crear(Cliente cliente);	
	public Cliente findByUsuario(String unUsuario) throws UsuarioNoExisteException ;
	public boolean verifyUsuarioAndPassword(String unUsuario, String unPassword);
	public void deleteByUsuario(String unUsuario);
}
