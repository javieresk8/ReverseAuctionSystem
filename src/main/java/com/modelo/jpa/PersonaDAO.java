package com.modelo.jpa;

import javax.persistence.Query;

import com.modelo.entidades.Persona;

public class PersonaDAO<T, ID> extends GenericDAO<T, ID>{
	

	@SuppressWarnings("unchecked")
	public PersonaDAO() {
		super((Class<T>) Persona.class);
		// TODO Auto-generated constructor stub
	}
	

	public T autorizar(String cedula, String passwordHash){
		String sentenciaJPQL = "SELECT e FROM Persona e WHERE e.cedula = :param_cedula AND e.clave = :param_clave";
		Query query = em.createQuery(sentenciaJPQL);
		query.setParameter("param_cedula", cedula);
		query.setParameter("param_clave", passwordHash);
		@SuppressWarnings("unchecked")
		T resultado = (T)query.getSingleResult();
		return resultado;
	}

}
