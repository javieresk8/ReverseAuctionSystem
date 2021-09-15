package com.cifrado;

import java.math.BigInteger;

public class OkamotoUchiyama_p extends AbstractOkamotoUchiyama{
	
	/** Maximum number of bits allowed for keysize. */
	protected static final int MAX_KEY_SIZE = 512;
	protected OkamotoUchiyama_privateKey deckey= null;

	public OkamotoUchiyama_p(){
	}
	public OkamotoUchiyama_p(OkamotoUchiyama_key key){
	 this.key = key;
	 this.encryptMode=true;
	 }
	public OkamotoUchiyama_p(OkamotoUchiyama_privateKey key){
	 this(key.getPublicKey());
	 setDecryption(key);
	 }
	public void setEncryption(OkamotoUchiyama_key key){
	 this.key= key;
	 this.encryptMode=true;
	 return;
	 }

	public void setDecryption(OkamotoUchiyama_privateKey key){
	 this.deckey = key;
	 this.decryptMode=true;
	 return;
	 }

	public void setDecryptEncrypt(OkamotoUchiyama_privateKey key){
	 setDecryption(key);
	 setEncryption(key);
	 return;
	 }

	public OkamotoUchiyama_privateKey getPrivateKey(){
	 if(decryptMode){
	 return deckey;
	 }
	 return null;
	 }
	
	public BigInteger decrypt_ou(BigInteger c){
		 //System.out.println("Desencriptacion de "+ c.toString());
		 BigInteger m= null;
		 if(decryptMode==false)
		throw new IllegalStateException(this.notReadyForDecryption);
		 //Obtener las claves
		 BigInteger p= deckey.getP();
		 BigInteger g= super.key.getG();
		 //p-1
		 BigInteger pRest1= p;
		 pRest1= pRest1.subtract(BigInteger.ONE);
		 //p^2
		 BigInteger p2=p;
		 p2= p2.pow(2);
		 //formacion de argumentos funcion L
		 BigInteger c1= c.modPow(pRest1, p2);
		 BigInteger c2= g.modPow(pRest1, p2);
		 //Resultados funcion L.
		 BigInteger l1 =
		(c1.subtract(BigInteger.ONE)).divide(p);
		 BigInteger l2 =
		(c2.subtract(BigInteger.ONE)).divide(p);
		 //Aplicación de modulo inverso a L(g^(p-1) mod p^2)
		 BigInteger l2_i= l2.modInverse(p);
		 //Obtención de texto plano m
		 m= (l2_i.multiply(l1)).mod(p);
		 return m;
		 }

}
