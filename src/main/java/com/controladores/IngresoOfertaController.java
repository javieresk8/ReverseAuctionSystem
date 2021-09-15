package com.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.entidades.EntidadContratante;
import com.modelo.entidades.Oferta;
import com.modelo.entidades.Ofertante;

@WebServlet("/IngresoOfertaController")
public class IngresoOfertaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Oferta oferta;

	public IngresoOfertaController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/jsp/ofertar.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer oferta = Integer.parseInt(request.getParameter("oferta"));
		// session
		HttpSession sesion = request.getSession();
		// seteo objeto entidad
		Ofertante ofertante = (Ofertante) sesion.getAttribute("usuarioLogueado");
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
