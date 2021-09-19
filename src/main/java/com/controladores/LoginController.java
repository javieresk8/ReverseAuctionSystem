package com.controladores;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get en Login");
		String path = "/jsp/index.jsp";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post en Login");
		String cedula = request.getParameter("email");
		String passwordHash = request.getParameter("password");
		
		//session
		HttpSession sesion = request.getSession();
		
		PersonaDAO personaAAurotizar = new PersonaDAO();
		Persona personaAutorizada=null;
		try {
			personaAutorizada = personaAAurotizar.autorizar(cedula, passwordHash);
			System.out.println(personaAutorizada.getTipoDeUsuario());
		} catch (Exception e) {
			e.printStackTrace();
		}
													//cedula y password hasheada
		
		//verificar
		if(personaAutorizada==null) {
			System.out.println("No existe el usuario");
			doGet(request, response);
		}else{
			switch (personaAutorizada.getTipoDeUsuario()) {
				case "EntidadContratante": {
					sesion.setAttribute("usuarioLogueado", personaAutorizada);
					request.getRequestDispatcher("/ListarRequerimientosController").forward(request, response);
					break;
				}
				case "Ofertante": {
					sesion.setAttribute("usuarioLogueado", personaAutorizada);
					request.getRequestDispatcher("/MostrarRequerimientosController").forward(request, response);
					break;
				}
				default:
					doGet(request, response);
					break;
			}
		}
		
		doGet(request, response);
	}


	

}
