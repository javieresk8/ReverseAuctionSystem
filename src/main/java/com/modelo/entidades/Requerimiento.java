package com.modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="Requerimiento")
public class Requerimiento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idRequerimiento")
	private Integer id;
	
	@Column(name="precio")
	private int precio;//en centavos
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "requerimiento")
	private Set<Oferta> listaDeOfertas = new HashSet<Oferta>();
	*/
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="proyecto")
	private Proyecto proyecto;
	
	public Requerimiento() {
		super();
	}
	
	public Requerimiento(String nombreRequerimiento, String descripcionRequerimiento) {
		nombre = nombreRequerimiento;
		descripcion= descripcionRequerimiento;
	}

	/*
	public void añadirOferta(Oferta ofertaAAnaiadir) {
		listaDeOfertas.add(ofertaAAnaiadir);
	}
	*/

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	/*
	public ArrayList<Oferta> getListaDeOfertas() {
		return listaDeOfertas;
	}

	public void setListaDeOfertas(ArrayList<Oferta> listaDeOfertas) {
		this.listaDeOfertas = listaDeOfertas;
	}
	
	public void añadirOferta(Oferta ofertaAAnaiadir) {
		listaDeOfertas.add(ofertaAAnaiadir);
	}
	*/
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
	/*
	public Set<Oferta> getListaDeOfertas() {
		return listaDeOfertas;
	}
	

	public void setListaDeOfertas(Set<Oferta> listaDeOfertas) {
		this.listaDeOfertas = listaDeOfertas;
	}
	*/

	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
