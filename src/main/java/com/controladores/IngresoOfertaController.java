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
import com.modelo.entidades.Requerimiento;
import com.modelo.jpa.OfertaDAO;
import com.modelo.jpa.OfertanteDAO;
import com.modelo.jpa.RequerimientoDAO;

@WebServlet("/IngresoOfertaController")
public class IngresoOfertaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	public IngresoOfertaController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer requerimientoId = Integer.parseInt(request.getParameter("requerimientoId"));
		
		RequerimientoDAO requerimientoDao = new RequerimientoDAO();
		Requerimiento requerimiento=requerimientoDao.getById(requerimientoId);
		
		request.setAttribute("requerimiento", requerimiento);
		String path = "/jsp/ofertar.jsp";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ofertaValor = Integer.parseInt(request.getParameter("ofertaValor"));
		
		// session
		HttpSession sesion = request.getSession();
		// seteo objeto entidad
		Ofertante ofertante = (Ofertante) sesion.getAttribute("usuarioLogueado");
		ofertante.añadirOferta(ofertaValor);
		
		OfertanteDAO ofertanteDao = new OfertanteDAO();
		ofertanteDao.update(ofertante);
		
		String path = "/MostrarRequerimientosController";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}



}
