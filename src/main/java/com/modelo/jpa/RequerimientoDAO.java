package com.modelo.jpa;

import java.util.List;

import com.modelo.entidades.Requerimiento;

public class RequerimientoDAO extends GenericDAO<Requerimiento, Integer> {

	public RequerimientoDAO() {
		super(Requerimiento.class);
		// TODO Auto-generated constructor stub
	}

	public List<Requerimiento> obtenerRequerimientosPorProyecto(Integer idProyecto) {
		// TODO Auto-generated method stub
		return null;
	}
}
