package com.modelo.entidades;

public class EntidadContratante extends Persona {
	
	private Proyecto proyecto;
	
	public void agregarRequerimiento(Requerimiento requerimiento) {
		proyecto.agregarRequerimiento(requerimiento);
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
