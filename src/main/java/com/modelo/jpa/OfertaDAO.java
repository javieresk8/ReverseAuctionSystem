package com.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.modelo.entidades.Oferta;
import com.modelo.entidades.Requerimiento;

public class OfertaDAO extends GenericDAO<Oferta, Integer>{

	public OfertaDAO() {
		super(Oferta.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Oferta> getOfertasByRequerimiento(Integer idRequerimiento) {
		String sentenciaSQL = "SELECT r.idOferta FROM oferta r WHERE r.requerimiento = " + idRequerimiento + ";";
		Query query = em.createNativeQuery(sentenciaSQL);
		@SuppressWarnings("unchecked")
		List<Integer> resultado = query.getResultList();
		List<Oferta> ofertas = new ArrayList<Oferta>();
		for(Integer i: resultado) {
			ofertas.add(new OfertaDAO().getById(i));
		}
		return ofertas;
	}

}
