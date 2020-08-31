package com.farmatodo.tienda.dto;

import java.util.Collection;

public class CompraDTO {
	
	private int idTienda;
	
	private int idCliente;
	
	private Collection<Integer> idProductos;	
	
	public int getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Collection<Integer> getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(Collection<Integer> idProductos) {
		this.idProductos = idProductos;
	}	
}
