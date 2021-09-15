package com.modelo.entidades;

import java.util.ArrayList;

public class Requerimiento {

	public int precio;//en centavos
	public ArrayList<Oferta> listaDeOfertas;
	public String nombre;
	public String descripcion;
	
	public Requerimiento(String nombreRequerimiento, String descripcionRequerimiento) {
		nombre = nombreRequerimiento;
		descripcion= descripcionRequerimiento;
	}

	public void añadirOferta(Oferta ofertaAAnaiadir) {
		listaDeOfertas.add(ofertaAAnaiadir);
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public ArrayList<Oferta> getListaDeOfertas() {
		return listaDeOfertas;
	}

	public void setListaDeOfertas(ArrayList<Oferta> listaDeOfertas) {
		this.listaDeOfertas = listaDeOfertas;
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
	
	
}
