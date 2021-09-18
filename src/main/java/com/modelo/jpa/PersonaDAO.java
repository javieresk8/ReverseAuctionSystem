package com.modelo.jpa;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Query;

import com.cifrado.AlgoritmoHash;
import com.cifrado.AES;
import com.cifrado.Encriptar;
import com.modelo.entidades.Persona;

public class PersonaDAO<T, ID> extends GenericDAO<T, ID>{
	

	@SuppressWarnings("unchecked")
	public PersonaDAO() {
		super((Class<T>) Persona.class);
		// TODO Auto-generated constructor stub
	}
	

	public Persona autorizar(String cedula, String password){
		AES aes=new AES();
	    AlgoritmoHash hash=new AlgoritmoHash();
		String cedula1=aes.encriptar(cedula);
		System.out.println(cedula1);
		String password1;
		Persona persona=null;
		try {
			password1 = hash.obtenerHash(password);
			em.getTransaction().begin();
			Query query = em.createNativeQuery("SELECT p.idPersona, p.tipoUsuario, p.apellido, p.cedula, p.password, p.nombre, p.cantidadOfertas, p.sumaOfertas FROM persona p  WHERE cedula=? AND password=?");
			query.setParameter(1, cedula1);
			query.setParameter(2, password1);
			
			Object[] resultado = (Object[]) query.getSingleResult();
		
			em.getTransaction().commit();
			persona=new Persona(aes.desencriptar(resultado[5].toString()),aes.desencriptar(resultado[2].toString()), resultado[4].toString(),aes.desencriptar(resultado[3].toString()), resultado[1].toString());
		    persona.setId(Integer.parseInt(resultado[0].toString()));	
		} catch (Exception e) {
			persona=null;
			//e.printStackTrace();
		}
	
		
		
		return persona;
	}


	
	
	

}
