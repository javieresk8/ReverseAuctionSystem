package com.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.entidades.EntidadContratante;
import com.modelo.entidades.Requerimiento;
import com.modelo.jpa.RequerimientoDAO;

@WebServlet("/AniadirRequerimientoController")
public class AniadirRequerimientoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get para setear estado
		// parámetro que se me envía para iniciar o terminar un proyecto
		Boolean cedula = Boolean.parseBoolean(request.getParameter("estado"));

		// session
		HttpSession sesion = request.getSession();
		// seteo objeto entidad
		EntidadContratante entidad = (EntidadContratante) sesion.getAttribute("usuarioLogueado");

		if (cedula)
			entidad.getProyecto().iniciar();
		else
			entidad.getProyecto().terminar();

		// reenvío a la vista de la entidad contratante
		String path = "ListarRequerimientosController";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post para agregar un requerimiento
		String nombreRequerimiento = request.getParameter("nombreRequerimiento");
		String descripcionRequerimiento = request.getParameter("descripcionRequerimiento");

		// session
		HttpSession sesion = request.getSession();
		// seteo objeto entidad
		EntidadContratante entidad = (EntidadContratante) sesion.getAttribute("usuarioLogueado");


		Requerimiento requerimiento = new Requerimiento(nombreRequerimiento, descripcionRequerimiento,
																				entidad.getProyecto());

		// agrego requerimiento
		RequerimientoDAO reu=new RequerimientoDAO();
		reu.create(requerimiento);
		// reenvío a la vista de la entidad contratante
		String path = "/ListarRequerimientosController";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
