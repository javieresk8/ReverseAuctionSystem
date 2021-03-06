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
public class ListarRequerimientosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		//EntidadContratante entidad = (EntidadContratante) request.getSession().getAttribute("usuarioLogueado");
		
		RequerimientoDAO requerimientoDao = new RequerimientoDAO();
		
		//m?todo sin id de proyecto brah
		List<Requerimiento> requerimientos= requerimientoDao.get();
		
		request.setAttribute("requerimientos", requerimientos);
		// reenv?o a la vista de la entidad contratante
		String path = "/jsp/admin-requerimientos.jsp";
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
