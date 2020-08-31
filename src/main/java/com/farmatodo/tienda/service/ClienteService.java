package com.farmatodo.tienda.service;

import com.farmatodo.tienda.entity.Cliente;
import com.farmatodo.tienda.exception.ClaveInvalidaException;
import com.farmatodo.tienda.exception.UsuarioNoExisteException;

public interface ClienteService {
	public void crear(Cliente cliente);
	public Cliente autenticarUsuario(String unUsuario, String password) throws UsuarioNoExisteException, ClaveInvalidaException ;
	public void deleteByUsuario(String unUsuario);
}
