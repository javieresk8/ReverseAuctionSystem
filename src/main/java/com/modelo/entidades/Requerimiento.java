package com.modelo.entidades;

import java.util.ArrayList;

public class Requerimiento {

	public int precio;//en centavos
	public ArrayList<Oferta> listaDeOfertas;
	
	
	public void añadirOferta(Oferta ofertaAAnaiadir) {
		listaDeOfertas.add(ofertaAAnaiadir);
	}
}
