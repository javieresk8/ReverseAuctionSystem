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
		
		//Nuevo diseño
		
		//Autorizar
		//System.out.println(new OfertanteDAO().autorizar("1201384060", "1234"));
		
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
		
		RequerimientoDAO dao = new RequerimientoDAO();
		if(dao.get().size()!=0) {
			for(Requerimiento r: dao.get()) {
				System.out.println(r.toString());
			}
		}
		
	}
}
