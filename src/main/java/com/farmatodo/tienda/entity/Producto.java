package com.farmatodo.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private	int id;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio")
	private int precio;
	
	@Column(name="codigo_barras")	
	private String codigoBarras;
	 
	@Column(name="estado")	
	private String estado;
	/* Toma los valosres DISPONIBLE y VENDIDO */

	public int getId() {
		return id;
	}

	public void setId(int idProducto) {
		this.id = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
