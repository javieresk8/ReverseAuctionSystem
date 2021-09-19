package com.cifrado;

import java.math.BigInteger;

public class Encriptar {
    public Benaloh b;
    
    public Encriptar() {
        this.b=new Benaloh();
          b.keyGeneration(64);
    }

    public BigInteger encriptar(BigInteger valorAEncriptar) {
        int aux=valorAEncriptar.intValue();
        BigInteger salida=b.encrypt(aux);

        return salida;
    }


    public BigInteger desencriptar(BigInteger valorEncriptado) {
        BigInteger salida=null;
        salida=new BigInteger(String.valueOf(b.decrypt(valorEncriptado)));
        return salida;
    }

    public BigInteger sumaHomorfica(BigInteger valorEncriptado1, BigInteger valorEncriptado2) {
        BigInteger salida=null;
        salida=b.add(valorEncriptado1, valorEncriptado2);
        return salida;
    }


}

