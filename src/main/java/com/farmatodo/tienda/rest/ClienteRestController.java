package com.farmatodo.tienda.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmatodo.tienda.entity.Cliente;
import com.farmatodo.tienda.exception.ClaveInvalidaException;
import com.farmatodo.tienda.exception.UsuarioNoExisteException;
import com.farmatodo.tienda.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	private ClienteService clienteService;
	
	@Autowired
	public ClienteRestController(ClienteService unClienteService) {
		clienteService = unClienteService ;
	}
	
	@ExceptionHandler({ UsuarioNoExisteException.class, ClaveInvalidaException.class })
	@GetMapping("/clientes/{usuario}/{password}")	
	public Cliente
	autenticarUsuario(@PathVariable String usuario, @PathVariable String password) throws UsuarioNoExisteException, ClaveInvalidaException {
		Cliente cliente = null ;
		System.out.println("usuario >>" + usuario );
		System.out.println("password >>" + password );
		
		cliente = clienteService.autenticarUsuario(usuario,password);
		
		return cliente ;
	}
	
	@PostMapping("/clientes")
	public Cliente crearCliente(@RequestBody Cliente unCliente) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		unCliente.setIdCliente(0);
		
		clienteService.crear(unCliente);
		
		return unCliente;
	}

	
	@PutMapping("/clientes")	
	public void updateCliente(@RequestBody Cliente unCliente) {
		clienteService.crear(unCliente);
	}	
	
	@DeleteMapping("/clientes/{unUsuario}")	
	public void deleteByUsuario(@PathVariable String unUsuario) {
		clienteService.deleteByUsuario(unUsuario);
	}	
}
