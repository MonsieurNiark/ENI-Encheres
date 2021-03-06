package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			
		HttpSession session = request.getSession();
		
		
		
		//recuperation des variables session		

		if(session.getAttribute("isConnecte") == null)
		{
			request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward( request,  response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/index");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String identifiant = request.getParameter("user");
		String motDePasse = request.getParameter("mdp");
		Boolean seSouvenirDeMoi = Boolean.parseBoolean(request.getParameter("seSouvenirDeMoi"));
		UtilisateurManager utilMana  = new UtilisateurManager();
		Utilisateur utilisateurLog = null;
		HttpSession session = request.getSession();
		
		//lorsque case coché ça garde tout le temps en session meme si decocher, premier affichage de la page -> affiche null
		if(seSouvenirDeMoi == true) {
			session.setAttribute( "identifiant", identifiant);
		}
			try {
				utilisateurLog = utilMana.selectionnerUtilisateurByPseudo(identifiant);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
			}
		
			String motDePasseUser = utilisateurLog.getMotDePasse();
			
		
			if( utilisateurLog == null || !motDePasseUser.equals(motDePasse) )
			{
			
				session.setAttribute("erreur", "Login ou Password incorrect");
				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);

			}
			else if(utilisateurLog != null && motDePasseUser.equals(motDePasse))
			{
			
				session.setAttribute( "isConnecte", true ); //récupération
				session.setAttribute( "isAdministrateur", utilisateurLog.getAdministrateur() );
				session.setAttribute("actualUser", identifiant);
				session.setAttribute("idUser", utilisateurLog.getNoUtilisateur());
				session.setAttribute( "succes", "Vous êtes connecté");
				session.setAttribute("credit", utilisateurLog.getCredit());
				response.sendRedirect(request.getContextPath()+"/index");

			}
		
		}	
	
}
