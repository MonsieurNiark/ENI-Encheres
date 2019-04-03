package fr.eni.encheres.servlet;

import java.io.IOException;
import java.math.BigInteger;

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
		String identifiant = request.getParameter("user");
		String motDePasse = request.getParameter("mdp");		
		Boolean isAdministrateur = Boolean.parseBoolean(request.getParameter("seSouvenirDeMoi"));
		
		if(identifiant == null )identifiant="";
		if(motDePasse == null )motDePasse="";
		
		request.setAttribute("identifiant", identifiant);
		request.setAttribute("motDePasse", motDePasse);
		//recuperation des variables session		

		
		request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward( request,  response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String identifiant = request.getParameter("user");
		String motDePasse = request.getParameter("mdp");
		UtilisateurManager utilMana  = new UtilisateurManager();
		Utilisateur utilisateurLog = null;
		HttpSession session = request.getSession();

		
			try {
				utilisateurLog = utilMana.selectionnerUtilisateurByPseudo(identifiant);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
			}
		
			String motDePasseUser = utilisateurLog.getMotDePasse();
			
		
			if( utilisateurLog == null || !motDePasseUser.equals(motDePasse) )
			{
				if (utilisateurLog == null)System.out.println("user null");
				if (!motDePasseUser.equals(motDePasse))System.out.println("mot de passe diff");
				System.out.println("|"+motDePasse+"|");
				System.out.println("|"+motDePasseUser+"|");
				System.out.println("ERREUR");
				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
			}
			else if(utilisateurLog != null && motDePasseUser.equals(motDePasse))
			{
				System.out.println("PAS ERREUR");
				response.sendRedirect(request.getContextPath()+"/inscription");
				session.setAttribute("identifiant", identifiant);
	
			}
		
		}	

}
