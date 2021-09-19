package com.cifrado;

import java.math.BigInteger;

public class Encriptar {

     public static int a=20;
     public static long b=14656546;
     public static BigInteger salida;
     public static OUKeyGen OUkg=new OUKeyGen();
     public static OkamotoUchiyama_p esystem= new OkamotoUchiyama_p();
     public static OkamotoUchiyama_privateKey key=OUkg.OkamotoUchiyamaKey(a,b);





public static BigInteger encriptar(BigInteger valorAEncriptar) {
    BigInteger salida=null;
    esystem.setDecryptEncrypt(key);
    salida=esystem.encrypt_ou(valorAEncriptar);
    return salida;
}


public static BigInteger desencriptar(BigInteger valorEncriptado) {
    BigInteger salida=null;
    esystem.setDecryptEncrypt(key);
    salida=esystem.decrypt_ou(valorEncriptado);
    return salida;
}

public static BigInteger sumaHomorfica(BigInteger valorEncriptado1, BigInteger valorEncriptado2) {
    BigInteger salida=null;
    salida=esystem.addOU(valorEncriptado2, valorEncriptado1);
    return salida;
}


}

/*
package com.cifrado;

import java.math.BigInteger;

public class Encriptar {
	
	 public int a;
	 public long b;
	 public BigInteger salida;
	 public OUKeyGen OUkg;
	 public OkamotoUchiyama_p esystem;
	 public OkamotoUchiyama_privateKey key;
	 
	 
	
public Encriptar() {
	 this.a=20;
	 this.b=14656546;
	 this.OUkg = new OUKeyGen();
	 this.esystem= new OkamotoUchiyama_p();
	 this.key=OUkg.OkamotoUchiyamaKey(a,b);	
	}


public BigInteger encriptar(BigInteger valorAEncriptar) {
    BigInteger salida=null;
	esystem.setDecryptEncrypt(key);
	salida=esystem.encrypt_ou(valorAEncriptar);
	return salida;
}


public BigInteger desencriptar(BigInteger valorEncriptado) {
	BigInteger salida=null;
	esystem.setDecryptEncrypt(key);
	salida=esystem.decrypt_ou(valorEncriptado);
	return salida;
}

public BigInteger sumaHomorfica(BigInteger valorEncriptado1, BigInteger valorEncriptado2) {
	BigInteger salida=null;
	salida=esystem.addOU(valorEncriptado2, valorEncriptado1);
	return salida;
}


}
*/


/*

public BigInteger encriptar(BigInteger valorAEncriptar) {
	int a=20;
	long b=14656546;
	BigInteger salida=null;
	 OUKeyGen OUkg = new OUKeyGen();
	 OkamotoUchiyama_p esystem= new OkamotoUchiyama_p();
	 OkamotoUchiyama_privateKey key=OUkg.OkamotoUchiyamaKey(a,b);
	 esystem.setDecryptEncrypt(key);
	salida=esystem.encrypt_ou(valorAEncriptar);
	return salida;
}


public BigInteger desencriptar(BigInteger ValorEncriptado) {
	int a=20;
	long b=14656546;
	BigInteger salida=null;
	 OUKeyGen OUkg = new OUKeyGen();
	 OkamotoUchiyama_p esystem= new OkamotoUchiyama_p();
	 OkamotoUchiyama_privateKey key=OUkg.OkamotoUchiyamaKey(a,b);
	 esystem.setDecryptEncrypt(key);
	salida=esystem.encrypt_ou(ValorEncriptado);
	return salida;
}*/









