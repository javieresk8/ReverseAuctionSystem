package com.modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Ofertante")
public class Ofertante extends Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//@OneToOne
	//@JoinColumn(name="oferta")
	//private Oferta oferta;
	
	@Column(name="sumaOfertas")
	private String sumaOfertas;
	
	@Column(name="cantidadOfertas")
	private String cantidadOfertas;
	
	public Ofertante() {
		super();
		this.setTipoDeUsuario("Ofertante");
	}
	
	
	/*
	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	*/


	@Override
	public String toString() {
		//return "Ofertante [" + super.toString() + ", oferta=" + oferta + "]";
		return "Ofertante [" + super.toString() + "]";
	}


	public void a�adirOferta(Integer ofertaValor) {
		// TODO Auto-generated method stub
		
	}
	
	
}
