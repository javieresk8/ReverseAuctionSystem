package test;

import java.security.NoSuchAlgorithmException;


import com.modelo.entidades.Ofertante;
import com.modelo.entidades.Persona;
import com.modelo.jpa.OfertanteDAO;
import com.modelo.jpa.PersonaDAO;

public class Prueba {

	public static void main(String[] args) throws NoSuchAlgorithmException {
	OfertanteDAO ofertanteDAO=new OfertanteDAO();
	//ofertanteDAO.añadirOferta(1, 5600);
    
	//Ofertante ofertante=ofertanteDAO.getGanador();
	
	
	PersonaDAO personaAAurotizar = new PersonaDAO();
    Persona persona=personaAAurotizar.autorizar("1239849394","juan1234");
	System.out.println(persona.toString());
	//System.out.println(ofertante.toString());
	//System.out.println(ofertante.getSumaOfertas());
	
	
	
	
	
	}
	
	

}
