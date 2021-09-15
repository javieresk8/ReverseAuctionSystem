package com.cifrado;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class AlgoritmoHash {
	
	public String obtenerHash(String  entrada) throws NoSuchAlgorithmException{
	
		byte[] bytes=entrada.getBytes(StandardCharsets.UTF_8);
		MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
		messageDigest.update(bytes);
		bytes=messageDigest.digest();
		
		StringBuilder hexString = new StringBuilder(2 * bytes.length);
	    for (int i = 0; i < bytes.length; i++) {
	        String hex = Integer.toHexString(0xff & bytes[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
		
		
		
	}

}
