package com.cifrado;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class OUKeyGen {

	public static OkamotoUchiyama_privateKey
	OkamotoUchiyamaKey(int s, long seed){
	 if (s<=0) {
	 throw new IllegalArgumentException(
	"Number of bits set is less than 0");
	 }
	 /*valores llaves*/
	 BigInteger n, g, h, p, q;
	 SecureRandom rnd;
	 rnd= new SecureRandom(BigInteger.valueOf(seed).toByteArray());
	 p = getPrime(s, rnd); q = getPrime(s, rnd);
	 //cálculo de n
	 BigInteger p2= p.pow(2);
	 n= p2.multiply(q);
	 //cálculo de g
	 g= primitiveRootModulo_Gen(n, rnd, p);
	if (g.compareTo(BigInteger.ZERO)==0)
	throw new IllegalArgumentException("\nEl valor del int s ingresado ("+s+"), no permite que la llave g difiera de 0. Utilize un valor s<25 al llamar esta función.");
	 //cálculo de h= gn mod n
	 h= g.modPow(n,n);
	 return new OkamotoUchiyama_privateKey(p, q, n, g, h, seed);
	 }


	public static BigInteger primitiveRootModulo_Gen(BigInteger n, Random rnd,
	BigInteger p){
	 BigInteger g= null;
	 g= BigInteger.ONE;
	 BigInteger r= BigInteger.ZERO;
	 for (int idx=1; idx<= n.intValue(); ++idx){
	 int rand = rnd.nextInt(100);
	 if(primitiveRoot(p, rand)==true){
	 r= r.add(BigInteger.valueOf(rand)); break;
	 }
	 }
	 g=g.multiply(r);
	 return g;
	}
	
	//a= valor aleatorio, p llave p
	public static boolean primitiveRoot(BigInteger p, int a ) {
	 int i;
	 BigInteger val = BigInteger.valueOf(a);
	 for (i=2; i<p.intValue(); i++) {
	 val = val.multiply(val).mod(p);
	 if (val.equals(BigInteger.ONE))
	 break;
	 }
	 int test=BigInteger.valueOf(i).compareTo(p);
	 if(test==0) return true;
	 return false;
	 }
	public static BigInteger getPrime(int length, Random random) {
	 return BigInteger.probablePrime(length, random);
	 }
	
}
