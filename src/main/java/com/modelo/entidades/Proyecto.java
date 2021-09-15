package com.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Proyecto")
public class Proyecto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idProyecto")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name="estado")
	private Boolean estado;//null es no iniciado, true es que está abierto y false es que está cerrado

	//private ArrayList<Requerimiento> requerimientos;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
	//private Set<Requerimiento> requerimientos = new HashSet<Requerimiento>();
	
	public Proyecto() {
		super();
	}

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
	/*
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
	*/
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
