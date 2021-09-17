package com.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.entidades.EntidadContratante;
import com.modelo.entidades.Ofertante;
import com.modelo.entidades.Requerimiento;
import com.modelo.jpa.OfertanteDAO;
import com.modelo.jpa.RequerimientoDAO;

@WebServlet("/VerGanadorController")
public class VerGanadorController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//proceso homomórfico y devolver un ofertante ganador
		
		
		
		OfertanteDAO ofertanteDao = new OfertanteDAO();
		Ofertante ofertante= ofertanteDao.getGanador();
		
		request.setAttribute("ofertante", ofertante);
		// reenvío a la vista de la entidad contratante
		String path = "/jsp/ganadores.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
