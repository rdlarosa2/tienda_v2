package com.farmatodo.tienda.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compra")
	private int idCompra;
	
	@Column(name="id_tienda")
	private int idTienda;
	
	@Column(name="id_cliente")
	private int idCliente;
	
	@OneToMany
	@JoinTable( name="compra_producto",
	joinColumns=@JoinColumn(name="id_compra"),
	inverseJoinColumns=@JoinColumn(name="id_producto"))
	private
	Collection<Producto> productos;	

	public Compra() {
		idTienda = 0 ;
		idCliente = 0 ;
		productos = null ;		
	}
	
	public Compra(int unIdTienda, int unIdCliente, Collection<Producto> lstProductos) {
		idTienda = unIdTienda ;
		idCliente = unIdCliente ;
		productos = lstProductos ;
	}

	public int getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}
	
}
