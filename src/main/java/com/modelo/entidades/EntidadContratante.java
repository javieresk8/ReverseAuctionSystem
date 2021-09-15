package com.modelo.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("EntidadContratante")
public class EntidadContratante extends Persona implements Serializable{		

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="proyecto")
	private Proyecto proyecto;
	
	public EntidadContratante() {
		super();
		this.setTipoDeUsuario("EntidadContratante");
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public String toString() {
		return "EntidadContratante [" + super.toString() + "proyecto=" + proyecto.getNombre() + "]";
	}
	
	
}
