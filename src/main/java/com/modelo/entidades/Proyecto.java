package com.modelo.entidades;

import java.io.IOException;
import java.util.ArrayList;


public class Proyecto  {


	private ArrayList<Requerimiento> requerimientos;
	
	private String nombreDeProyecto;
	
	private Boolean estado;//null es no iniciado, true es que está abierto y false es que está cerrado
	
	public void iniciar() {
		//verificación de seguridad para que no se inicie un proyecto terminado
		if(estado==null)
			this.estado=true;
		
	}
	
	public void terminar() {
		//verifico que no sea null
		if(estado!=null)
			if(estado== null)//verifico que esté iniciado
				this.estado= false;
	}
	
	public void agregarRequerimiento(Requerimiento requerimiento) {
		requerimientos.add(requerimiento);
	}

	public ArrayList<Requerimiento> getRequerimientos() {
		return requerimientos;
	}

	public void setRequerimientos(ArrayList<Requerimiento> requerimientos) {
		this.requerimientos = requerimientos;
	}

	public String getNombreDeProyecto() {
		return nombreDeProyecto;
	}

	public void setNombreDeProyecto(String nombreDeProyecto) {
		this.nombreDeProyecto = nombreDeProyecto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
