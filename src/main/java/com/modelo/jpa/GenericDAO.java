package com.modelo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDAO<T, ID> {
	protected EntityManager em;
	private Class<T> persistenceClass;
	public GenericDAO(Class <T> persistentClass) {
		this.persistenceClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("ProyectoDSS").createEntityManager();

	}
	public List<T> get() {
		String consulta = "Select e from " + this.persistenceClass.getSimpleName() + " e";
		Query query = em.createQuery(consulta, this.persistenceClass);
		List<T> list = (List<T>) query.getResultList();
		return list;
	}

	public T getById(ID id) {
		return em.find(persistenceClass, id);
	}

	public void create(T entity) {
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

	public void update(T entity){
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Error" + e);
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
	}

	public void deleteById(ID idPersona){
		T entity = this.getById(idPersona);
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
		
	}
}
