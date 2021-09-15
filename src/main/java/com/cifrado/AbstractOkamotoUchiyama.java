package com.cifrado;
import java.math.BigInteger;



public abstract class AbstractOkamotoUchiyama {
	protected OkamotoUchiyama_key key=null;
	protected boolean encryptMode=false;
	protected boolean decryptMode=false;
	protected String notReadyForEncryption = "You must first call setEncrypt or setDecryptEncrypt before calling this method";
	protected String notReadyForDecryption = "You must first call setDecrypt or setDecryptEncrypt before calling this method";

	public OkamotoUchiyama_key getPublicKey(){
	if(key==null)
	 return null;
	return key.getPublicKey();
	}

	//Encriptación de Okamoto Uchiyama
	public BigInteger encrypt_ou(BigInteger m){
	BigInteger random = key.getRandom();
	return encrypt_ou(m, random,key);
	}

	public static BigInteger encrypt_ou(BigInteger m, BigInteger r,
	OkamotoUchiyama_key key){
	return encrypt_ou(m, r, key.getH(),key.getG(),key.getN());
	}
	public static BigInteger encrypt_ou(BigInteger m, BigInteger r,
	BigInteger h, BigInteger g, BigInteger n){
	if(!(OkamotoUchiyama_key.inModNStar(r,n))) {
	 throw new IllegalArgumentException("r must be relatively prime to n and 0 <= r < n");
	 } //c= g^m h^r mod n
	BigInteger c=null, gModN= BigInteger.ONE, hModN= BigInteger.ZERO;
	gModN= g;
	BigInteger t1= gModN.modPow(m, n);
	hModN= h;
	hModN=hModN.modPow(r,n);
	c= (t1.multiply(hModN)).mod(n);
	return c;
	}
	//Suma de valores cifrados de Okamoto-Uchiyama
	public BigInteger addOU(BigInteger c1, BigInteger c2){
	if(encryptMode==false)
	 throw new IllegalStateException(this.notReadyForEncryption);
	return (c1.multiply(c2).mod(key.getN()));
	} 
}
