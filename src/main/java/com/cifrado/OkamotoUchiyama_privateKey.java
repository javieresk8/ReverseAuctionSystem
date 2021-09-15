package com.cifrado;

import java.math.BigInteger;
import java.util.Random;

public class OkamotoUchiyama_privateKey extends OkamotoUchiyama_key {
	private static final long serialVersionUID = -5099676862115044452L;
	protected BigInteger p;
	protected BigInteger q;
	protected Random rnd=null;
	protected int k=0;
	public OkamotoUchiyama_privateKey(BigInteger p,BigInteger q,BigInteger 
			n,BigInteger g,BigInteger h, long seed){
	 super(n,g, h, seed);
	 this.p=p;
	 this.q=q;
	 }
	public BigInteger getP() {
	 return p;
	 }
	public BigInteger getQ() {
	 return q;
	 } 

}
