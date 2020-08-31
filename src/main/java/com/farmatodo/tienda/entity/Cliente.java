package com.farmatodo.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	// `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private	
	int idCliente;
	
	
	// `nombre_completo` varchar(100) DEFAULT NULL,
	@Column(name="nombre_completo")
	private	
	String nombreCompleto;

	// `edad` int(3) DEFAULT NULL,
	@Column(name="edad")
	private
	int edad;
	
	// id_tipo_documento int(11) NOT NULL ,
	@Column(name="id_tipo_documento")
	private	
	int idTipoDocumento;
	
	// `numero_documento` varchar(20) DEFAULT NULL,
	@Column(name="numero_documento")
	private	
	String numeroDocumento;
	
	// `correo` varchar(60) DEFAULT NULL,
	@Column(name="correo")
	private	
	String correo;
	
	// `usuario` varchar(60) NOT NULL,
	@Column(name="usuario")
	private	
	String usuario;
	
    //  `contrasegna` varchar(60) DEFAULT NULL,
	@Column(name="contrasegna")
	private	
	String contrasegna;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	String getCorreo() {
		return correo;
	}

	void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasegna() {
		return contrasegna;
	}

	public void setContrasegna(String contrasegna) {
		this.contrasegna = contrasegna;
	} 

}
