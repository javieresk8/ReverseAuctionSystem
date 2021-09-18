package com.modelo.jpa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import com.cifrado.Encriptar;
import com.modelo.entidades.Oferta;
import com.modelo.entidades.Ofertante;
import com.modelo.entidades.Proyecto;
import com.cifrado.*;

public class OfertanteDAO extends PersonaDAO<Ofertante,Integer>{

	public OfertanteDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//comparar todas las ofertas y retornar el ofertante ganador
	//algoritmo homomórfico 
	public Ofertante getGanador() {
		AES aes=new AES();
		Encriptar enc=new Encriptar();
		int numeroreq, aux1,aux2;
		BigInteger aux;
		em.getTransaction().begin();
		Query quer = em.createNativeQuery("Select count(idRequerimiento) from requerimiento");
  		System.out.println(quer.getSingleResult());
		Object auxiliar=quer.getSingleResult();
		numeroreq=Integer.parseInt(auxiliar.toString());
		em.getTransaction().commit();
		
		em.getTransaction().begin();
  		Query query = em.createNativeQuery("Select p.idPersona, p.tipoUsuario, p.apellido, p.cedula, p.password, p.nombre, p.cantidadOfertas, p.sumaOfertas from persona p where tipoUsuario='Ofertante'");
		List<Object[]> ofertantes= query.getResultList();
		List<Object[]> ofertantes1=new ArrayList<Object[]>();
		for (Object[] a : ofertantes) {
			BigInteger desenc=new BigInteger(a[6].toString());
			int ofer=Integer.parseInt(enc.desencriptar(desenc).toString());
			a[6]=enc.desencriptar(desenc).toString();
			if(ofer==numeroreq) {
				ofertantes1.add(a);
				
			}
		}
		
		BigInteger desenc=new BigInteger((ofertantes1.get(0))[7].toString());
		aux1=(enc.desencriptar(desenc)).intValue();
		aux2=0;
		em.getTransaction().commit();
		
				 for (int i = 1; i<ofertantes1.size(); i++) {
					 BigInteger de=new BigInteger(ofertantes1.get(i)[7].toString());
			           if(aux1>(enc.desencriptar(de)).intValue()) {
			        	   aux1=enc.desencriptar(de).intValue();
			        	   aux2=i;
			           }
			        }
		           
		Ofertante ofertante=new Ofertante();
		ofertante.setId(Integer.parseInt((ofertantes1.get(aux2))[0].toString()));
		ofertante.setNombre(aes.desencriptar((ofertantes1.get(aux2))[5].toString()));
		ofertante.setCedula(aes.desencriptar((ofertantes1.get(aux2))[3].toString()));
		ofertante.setSumaOfertas(String.valueOf(aux1));
		return ofertante;
	}
	
	
	public void añadirOferta(int idOfertante, int oferta) {
		BigInteger oferta1=BigInteger.valueOf(oferta);
		    Encriptar enc=new Encriptar();
			int numeroreq,numeroofertas,id=idOfertante;
			BigInteger cantidadOfertas, sumaOfertas, uno=new BigInteger("1");
			
			em.getTransaction().begin();
	  		Query quer = em.createNativeQuery("Select count(idRequerimiento) from requerimiento");
	  		System.out.println(quer.getSingleResult());
			Object auxiliar=quer.getSingleResult();
			numeroreq=Integer.parseInt(auxiliar.toString());
			em.getTransaction().commit();
			System.out.println(numeroreq);
			
			
			em.getTransaction().begin();
	  		Query query = em.createNativeQuery("Select cantidadOfertas, sumaOfertas from persona where idPersona=?");
			query.setParameter(1,id);
			Object[] resultado = (Object[]) query.getSingleResult();
			auxiliar= resultado[0];
			cantidadOfertas=new BigInteger(auxiliar.toString());
			auxiliar=resultado[1];
			sumaOfertas=new BigInteger(auxiliar.toString());
			em.getTransaction().commit();
	
			numeroofertas=(enc.desencriptar(cantidadOfertas)).intValue();
			if(numeroofertas<numeroreq) {
		    sumaOfertas=enc.sumaHomorfica(sumaOfertas, enc.encriptar(oferta1));
		    cantidadOfertas=enc.sumaHomorfica(cantidadOfertas, enc.encriptar(uno));
		    
		    em.getTransaction().begin();
	  		Query query1 = em.createNativeQuery("UPDATE persona set cantidadOfertas=?, sumaOfertas=? where idPersona=?");
			query1.setParameter(1, cantidadOfertas);
			query1.setParameter(2, sumaOfertas);
			query1.setParameter(3, id); 
			query1.executeUpdate();
			em.getTransaction().commit();
			}
			
		}
		
	}




