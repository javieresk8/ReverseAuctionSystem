package com.cifrado;


import java.security.MessageDigest;

import java.util.Arrays;


import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;







public class AES {

	private String llave="12345";       
    private String algoritmo= "SHA-1";
    private int keysize=16;
    private SecretKeySpec secretkeyspec;
    
    
             
   

    public AES() {
    	try {
			byte[] cadena=llave.getBytes("UTF-8");
			MessageDigest md=MessageDigest.getInstance(algoritmo);
			cadena=md.digest(cadena);
			cadena=Arrays.copyOf(cadena, keysize);
			this.secretkeyspec=new SecretKeySpec(cadena, "AES");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		}

	public String encriptar( String texto ){
		String cadenaEncriptada="";
        try {
			Cipher cipher=Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE,this.secretkeyspec);
			byte[] cadena= texto.getBytes("UTF-8");
			byte[] encriptada=cipher.doFinal(cadena);
			cadenaEncriptada =Base64.encodeBase64String(encriptada);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        return cadenaEncriptada;
    }

    public String desencriptar( String texto ){
    	String cadenadesencriptada="";
        try {
			Cipher cipher=Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE,this.secretkeyspec);
			byte[] cadena=Base64.decodeBase64(texto);
			byte[] desencriptacion=cipher.doFinal(cadena);
			cadenadesencriptada=new String(desencriptacion);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        return cadenadesencriptada;
    }
}
