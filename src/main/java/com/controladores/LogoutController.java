package com.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.entidades.EntidadContratante;
import com.modelo.entidades.Ofertante;
import com.modelo.entidades.Persona;
import com.modelo.jpa.PersonaDAO;

@WebServlet("/LoginController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// session
		HttpSession sesion = request.getSession();

		Persona personaAutorizada = (Persona) sesion.getAttribute("usuarioLogueado");

		
		switch (personaAutorizada.getTipoDeUsuario()) {
		case "EntidadContratante": {
			request.getSession().invalidate();
			String path = "/jsp/index.jsp";
			getServletContext().getRequestDispatcher(path).forward(request, response);
			break;
		}
		case "Ofertante": {
			request.getSession().invalidate();
			String path = "/jsp/index.jsp";
			getServletContext().getRequestDispatcher(path).forward(request, response);
			break;
		}
		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
