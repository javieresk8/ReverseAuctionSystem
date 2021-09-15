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
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get en Login");
		String path = "/jsp/index.html";
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post en Login");
		String cedula = request.getParameter("email");
		String passwordHash = this.hashearClave(request.getParameter("password"));//clave hasheada
		
		//session
		HttpSession sesion = request.getSession();
		
		PersonaDAO personaAAurotizar = new PersonaDAO();
		EntidadContratante s= new EntidadContratante();
		Persona personaAutorizada = personaAAurotizar.autorizar(cedula, passwordHash);
		
		//verificar
		if(personaAutorizada==null) {
			System.out.println("No existe el usuario");
			doGet(request, response);
		}else{
			switch (personaAutorizada.getTipoDeUsuario()) {
				case "EntidadContratante": {
					EntidadContratante entidadContratante = (EntidadContratante) personaAutorizada;
					sesion.setAttribute("usuarioLogueado", entidadContratante);
					request.getRequestDispatcher("/ListarRequerimientosController").forward(request, response);
					break;
				}
				case "Ofertante": {
					Ofertante ofertante = (Ofertante) personaAutorizada;
					sesion.setAttribute("usuarioLogueado", ofertante);
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

	private String hashearClave(String clave) {
		
		return null;
	}


	

}
