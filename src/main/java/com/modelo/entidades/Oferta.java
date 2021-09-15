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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Oferta")
public class Oferta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idOferta")
	private Integer id;
	
	@Column(name="valor")
	private int valor;//en centavos según el internet
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="requerimiento")
	private Requerimiento requerimiento;

	public Oferta() {
		super();
	}

	public Oferta(int valor, Requerimiento requerimiento) {
		super();
		this.valor = valor;
		this.requerimiento = requerimiento;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", valor=" + valor + ", requerimiento=" + requerimiento + "]";
	}
	
	
	
}
