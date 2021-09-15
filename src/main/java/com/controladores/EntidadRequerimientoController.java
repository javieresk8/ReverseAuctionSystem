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

@WebServlet("/EntidadRequerimientoController")
public class EntidadRequerimientoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get para setear estado
		// par�metro que se me env�a para iniciar o terminar un proyecto
		Boolean cedula = Boolean.parseBoolean(request.getParameter("estado"));

		// session
		HttpSession sesion = request.getSession();
		// seteo objeto entidad
		EntidadContratante entidad = (EntidadContratante) sesion.getAttribute("usuarioLogueado");

		if (cedula)
			entidad.getProyecto().iniciar();
		else
			entidad.getProyecto().terminar();

		// reenv�o a la vista de la entidad contratante
		String path = "/jsp/admin-requerimientos.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post para agregar un requerimiento
		String nombreRequerimiento = request.getParameter("nombreRequerimiento");
		String descripcionRequerimiento = request.getParameter("descripcionRequerimiento");

		Requerimiento requerimiento = new Requerimiento(nombreRequerimiento, descripcionRequerimiento);

		// session
		HttpSession sesion = request.getSession();
		// seteo objeto entidad
		EntidadContratante entidad = (EntidadContratante) sesion.getAttribute("usuarioLogueado");

		// agrego requerimiento
		entidad.getProyecto().agregarRequerimiento(requerimiento);

		// reenv�o a la vista de la entidad contratante
		String path = "/jsp/admin-requerimientos.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
