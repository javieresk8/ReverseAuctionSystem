package test;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

import com.cifrado.AlgoritmoHash;
import com.cifrado.Encriptar;
import com.cifrado.OUKeyGen;
import com.cifrado.OkamotoUchiyama_p;
import com.cifrado.OkamotoUchiyama_privateKey;
import com.modelo.entidades.*;
import com.modelo.jpa.*;


public class Main {
	
	
	public static void testOneSizeOkaUchi(){
		int a=20;
		long b=14656546;
		
		 OUKeyGen OUkg = new OUKeyGen();
		 OkamotoUchiyama_p esystem= new OkamotoUchiyama_p();
		 OkamotoUchiyama_privateKey key=OUKeyGen.OkamotoUchiyamaKey(a,b);
		 esystem.setDecryptEncrypt(key);
		 
		 BigInteger m=new BigInteger("456");
		 BigInteger c=null;

		 c=esystem.encrypt_ou(m);
		
		 BigInteger decryption=null;
		 decryption=esystem.decrypt_ou(c);
		 System.out.println("\tValor del texto inicial: "+m);
		 System.out.println("\tValor del texto cifrado: "+c);
		 System.out.println("\tValor del texto descifrado: "+decryption);
	}
	
	public static void homomorphicEncryption() {
		BigInteger valor1=new BigInteger("7");
		BigInteger valor2=new BigInteger("28");
		BigInteger sumah=null;
		Encriptar enc1=new Encriptar();
		BigInteger encr1=enc1.encriptar(valor1);
		BigInteger encr2=enc1.encriptar(valor2);
		sumah=enc1.sumaHomorfica(encr1, encr2);
		BigInteger des1=enc1.desencriptar(encr1);
		BigInteger des2=enc1.desencriptar(encr2);
		System.out.println("Valor 1:"+valor1);
		System.out.println("Valor 2:"+valor2);
		System.out.println("Valor 1 encriptado: "+encr1);
		System.out.println("Valor 2 encriptado: "+encr2);
		System.out.println("Valor de la suma homomorfica: "+sumah);
		System.out.println("Valor de la suma homomorfica: "+enc1.desencriptar(sumah));
		System.out.println("***************************");
		System.out.println("Hashing");
	}
	
	public static void hashTest() {
		AlgoritmoHash hash=new AlgoritmoHash();
		try {
			System.out.println(hash.obtenerHash("Prueba de hash"));
			System.out.println(hash.obtenerHash("Prueba de hash1"));
			System.out.println(hash.obtenerHash("prueba de hash"));
			System.out.println(hash.obtenerHash("Prueba de hash"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	//MAIN
	
	public static void main(String[] args) {
		//Encriptacion
		//homomorphicEncryption();
		//hashTest();
		//testOneSizeOkaUchi();
		
		//JPA
		//Create
		/*
		Ofertante p = new Ofertante();
		p.setNombre("Jorge");
		p.setApellido("Guitierrez");
		p.setCedula("1201384060");
		OfertanteDAO dao = new OfertanteDAO();
		dao.create(p);
		*/
		Proyecto pro = new Proyecto();
		pro.setNombre("PRJ1");
		
		Requerimiento r1 = new Requerimiento();
		r1.setPrecio(45);
		r1.setProyecto(pro);
		
		Oferta o = new Oferta();
		o.setValor(50);
		o.setRequerimiento(r1);
		
		OfertaDAO dao = new OfertaDAO();
		dao.create(o);
		
	}
}
