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
public class VerGanadoresController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//
		
		Integer numeroDeRequerimiento = Integer.parseInt(request.getParameter("requerimiento"));
		
		EntidadContratante entidad = (EntidadContratante) request.getSession().getAttribute("usuarioLogueado");
		
		RequerimientoDAO requerimientoDao = new RequerimientoDAO();
		//TODO ganadores
		List<Requerimiento> requerimientos= requerimientoDao.obtenerRequerimientosPorProyecto(entidad.getProyecto().getId());
		
		request.setAttribute("ganadores", requerimientos);
		// reenvío a la vista de la entidad contratante
		String path = "/jsp/ganadores.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
