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
import com.modelo.entidades.Requerimiento;
import com.modelo.jpa.RequerimientoDAO;

@WebServlet("/ListarRequerimientosController")
public class VerRequerimientoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//envío del número de requerimiento a mostrar por get, empezando desde el 1,2,...
		Integer numeroDeRequerimiento = Integer.parseInt(request.getParameter("requerimiento"));
		
		
		RequerimientoDAO requerimientoDao = new RequerimientoDAO();
		
		
		Requerimiento requerimiento= requerimientoDao.getById(numeroDeRequerimiento);
		
		request.setAttribute("requerimiento", requerimiento);
		// reenvío a la vista de la entidad contratante
		String path = "/jsp/requerimiento.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
