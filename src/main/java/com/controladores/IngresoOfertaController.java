package com.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.entidades.Oferta;


@WebServlet("/IngresoOfertaController")
public class IngresoOfertaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Oferta oferta;

    public IngresoOfertaController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get en Ingreso");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post en Ingreso");
	}
	
	public boolean guardarOferta() {
		return false;
	}


	public Oferta getOferta() {
		return oferta;
	}


	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	
	

}
