package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String identifiant = request.getParameter("user");
		String motDePasse = request.getParameter("mdp");		

		boolean isAdministrateur = false;
		if(identifiant == null )identifiant="";
		if(motDePasse == null )motDePasse="";
		
		HttpSession session = request.getSession();
		request.setAttribute("identifiant", identifiant);
		request.setAttribute("motDePasse", motDePasse);
		//recuperation des variables session		

		session.setAttribute("isAdministrateur", isAdministrateur);
		
		request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward( request,  response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
