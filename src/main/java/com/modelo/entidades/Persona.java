package com.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoUsuario")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersona")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "cedula")
	private String cedula;
	
	@Column(name = "tipoUsuario")
	private String tipoDeUsuario;
	
	
	
	public Persona() {
		super();
	}
	
	public Persona(String nombre, String apellido, String cedula, String tipoDeUsuario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}
	public void setTipoDeUsuario(String tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

	
}
