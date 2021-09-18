package test;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

import com.cifrado.AES;
import com.cifrado.AlgoritmoHash;
import com.cifrado.Encriptar;
import com.modelo.entidades.Ofertante;
import com.modelo.entidades.Persona;
import com.modelo.jpa.OfertanteDAO;
import com.modelo.jpa.PersonaDAO;

public class Prueba {

	public static void main(String[] args) throws NoSuchAlgorithmException {
	OfertanteDAO ofertanteDAO=new OfertanteDAO();
	//ofertanteDAO.añadirOferta(1, 5600);
    
	//Ofertante ofertante=ofertanteDAO.getGanador();
	
	/*
	PersonaDAO personaAAurotizar = new PersonaDAO();
    Persona persona=personaAAurotizar.autorizar("1239849394","juan1234");
	System.out.println(persona.toString());
	*/
	BigInteger uno=new BigInteger("1");
	
	AES aes=new AES();
	Encriptar enc=new Encriptar();
	AlgoritmoHash hash=new AlgoritmoHash();
	
	String tipoUsuario="EntidadContratante";
	String apellido=aes.encriptar("Apolo");
	String cedula=aes.encriptar("1456345894");
	String password=hash.obtenerHash("password1");
	String nombre=aes.encriptar("Pedro");
	BigInteger cantidadOfertas=enc.encriptar(uno);
	BigInteger sumaOfertas=enc.encriptar(uno);
	
	PersonaDAO personadao=new PersonaDAO();
	personadao.insertarDB(tipoUsuario, apellido, cedula, password, nombre, cantidadOfertas, sumaOfertas);
	
	
	
	
	
	tipoUsuario="Ofertante";
	apellido=aes.encriptar("Romero");
	cedula=aes.encriptar("1982343233");
    password=hash.obtenerHash("pass");
	nombre=aes.encriptar("Jose");
	cantidadOfertas=enc.encriptar(uno);
	sumaOfertas=enc.encriptar(uno);
	personadao.insertarDB(tipoUsuario, apellido, cedula, password, nombre, cantidadOfertas, sumaOfertas);
	
	
	tipoUsuario="Ofertante";
	apellido=aes.encriptar("Perez");
	cedula=aes.encriptar("1143437656");
    password=hash.obtenerHash("pass1");
	nombre=aes.encriptar("Manuel");
	cantidadOfertas=enc.encriptar(uno);
	sumaOfertas=enc.encriptar(uno);
	personadao.insertarDB(tipoUsuario, apellido, cedula, password, nombre, cantidadOfertas, sumaOfertas);
	
	tipoUsuario="Ofertante";
	apellido=aes.encriptar("Florez");
	cedula=aes.encriptar("2394853434");
    password=hash.obtenerHash("pass2");
	nombre=aes.encriptar("Juan");
	cantidadOfertas=enc.encriptar(uno);
	sumaOfertas=enc.encriptar(uno);
	personadao.insertarDB(tipoUsuario, apellido, cedula, password, nombre, cantidadOfertas, sumaOfertas);
	
	
	
	}
	
	

}
