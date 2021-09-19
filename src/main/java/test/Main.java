package test;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.cifrado.AES;
import com.cifrado.AlgoritmoHash;
import com.cifrado.Encriptar;
import com.cifrado.OUKeyGen;
import com.cifrado.OkamotoUchiyama_p;
import com.cifrado.OkamotoUchiyama_privateKey;
import com.modelo.entidades.*;
import com.modelo.jpa.*;


public class Main {

	//MAIN
	
	public static void main(String[] args) {
		
		//JPA
		
		//Crear Entidad Contratante
		/*
		EntidadContratante e = new EntidadContratante();
		e.setNombre("Jaime");
		e.setApellido("Sabines");
		e.setCedula("1724421928");
		e.setClave("1234");
		
		EntidadContratanteDAO daoE = new EntidadContratanteDAO();
		daoE.create(e);
		*/
		
		//Crear Ofertante
		/*
		Ofertante of = new Ofertante();
		of.setNombre("Marcos");
		of.setApellido("Aguirre");
		of.setCedula("1201384060");
		of.setClave("0101");
		
		OfertanteDAO daoO = new OfertanteDAO();
		daoO.create(of);
		*/
		
		//Crear Requerimiento
		/*
		Requerimiento r = new Requerimiento();
		r.setNombre("R2");
		r.setDescripcion("Test2");
		
		RequerimientoDAO daoR = new RequerimientoDAO();
		daoR.create(r);
		*/
		Encriptar enc = new Encriptar();
		@SuppressWarnings("rawtypes")
		PersonaDAO dao = new PersonaDAO();
		@SuppressWarnings("unchecked")
		List<Persona> personas = dao.get();
		Ofertante of = null;
		BigInteger num = null;
		for(Persona o: personas) {
			if(o.getId().equals(19)) {
				of = (Ofertante) o;
				num = new BigInteger(of.getCantidadOfertas());
				System.out.println(enc.desencriptar(num));
			}
		}
		
		
		
		//BigInteger num1 = new BigInteger("405646942185328640");
		//System.out.println(Encriptar.desencriptar(num1));
		
		OfertanteDAO dao1 = new OfertanteDAO();
		//dao1.getOfertantes(19);
		//dao.añadirOferta(17, 50);
		System.out.println(dao1.getGanador().toString());
		AES aes=new AES();
		System.out.println(aes.desencriptar(dao1.getById(18).getCedula()));
	}
}
