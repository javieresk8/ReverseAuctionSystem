package com.cifrado;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class OkamotoUchiyama_key implements Serializable {
	private static final long serialVersionUID = 7296569067937928113L;

	protected Random rnd;
	protected BigInteger n;
	protected BigInteger g;
	protected BigInteger h;
	protected int k=0;

	public OkamotoUchiyama_key(){
	 n=null; g=null; h=null;
	 }
	public OkamotoUchiyama_key(BigInteger n,BigInteger g,BigInteger h, long
	seed){
	 this(n, g,h, new
	SecureRandom(BigInteger.valueOf(seed).toByteArray()));
	 }

	public OkamotoUchiyama_key(BigInteger n,BigInteger g,BigInteger h, Random
	rnd){
	 this.n=n; this.h=h; this.g=g;

	 this.rnd=rnd; k= n.bitLength();
	 }
	public OkamotoUchiyama_key getPublicKey(){
	 return new OkamotoUchiyama_key(n,g,h,rnd);
	 }

	public BigInteger getG() {
	 return g;
	 }
	public BigInteger getH() {
	 return h;
	 }
	public BigInteger getN() {
	 return n;
	}
	/** Metodos de Paillierkey.**/
	/*Metodo de que si un valor a existe en Zn */
	public static boolean inModN(BigInteger a, BigInteger n) {
	 return (a.compareTo(n) < 0 && a.compareTo(BigInteger.ZERO) >=
	0);
	}
	/*Método de que si un valor a existe en Zn* */
	public static boolean inModNStar(BigInteger a, BigInteger n) {
	 return (a.gcd(n).equals(BigInteger.ONE) && inModN(a, n));
	} 
	
	/*Generador aleatorio de r existente en Zn* */
	public BigInteger getRandomModNStar() {
	 BigInteger r;
	 do {
	 r = new BigInteger(k,rnd);
	 } while (!inModNStar(r, getN()));
	 return r;
	 }

	public BigInteger getRandom(){
	 BigInteger ret, key=getN();
	 do{
	 int i=rnd.nextInt();
	 if (i<0) i=(i*-1);
	 ret= BigInteger.valueOf(i);
	 }while(ret.compareTo(key)!=-1);
	 return ret;
	 } 
}
