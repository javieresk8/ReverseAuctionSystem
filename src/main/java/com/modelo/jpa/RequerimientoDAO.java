package com.modelo.jpa;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Query;

import com.modelo.entidades.Ofertante;
import com.modelo.entidades.Proyecto;

import com.modelo.entidades.Requerimiento;

public class RequerimientoDAO extends GenericDAO<Requerimiento, Integer> {

	public RequerimientoDAO() {
		super(Requerimiento.class);
		// TODO Auto-generated constructor stub
	}

	//ya no necesitamos ese id
	public List<Requerimiento> obtenerRequerimientosPorProyecto(Integer idProyecto) {
		String sentenciaSQL = "SELECT r.idRequerimiento FROM requerimiento r WHERE r.proyecto = " + idProyecto + ";";
		Query query = em.createNativeQuery(sentenciaSQL);
		@SuppressWarnings("unchecked")
		List<Integer> resultado1 = query.getResultList();
		List<Requerimiento> requerimientos = new ArrayList<Requerimiento>();
		for(Integer i: resultado1) {
			requerimientos.add(new RequerimientoDAO().getById(i));
		}
		return requerimientos;
	}
	
	
	

	@Override
	public void create(Requerimiento entity) {//algoritmo homomórfico cifrar, ver lo cifrado en la bd, sumar e ingresar
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error" + e);
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}
	
	
	
}
