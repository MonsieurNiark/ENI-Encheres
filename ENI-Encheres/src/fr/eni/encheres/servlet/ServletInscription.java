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
 * Servlet implementation class ServletInscirption
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if(!(boolean)session.getAttribute("isConnecte"))
		{
			request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward( request,  response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String codePostal = request.getParameter("codePostal");
		String mdp = request.getParameter("motDePasse");
		String conf = request.getParameter("confirmation");
		String msgError = "";
		boolean errorInscription= false;
		UtilisateurManager utilMana  = new UtilisateurManager();
		
		if(pseudo.equals("") || nom.equals("") || prenom.equals("") || email.equals("") || telephone.equals("") ||
				rue.equals("")|| ville.equals("")|| mdp.equals("") || conf.equals("")) {
			
			msgError = "Certains champs n'ont pas été renseignés";
			session.setAttribute("error", msgError);
			errorInscription = true;
		}
		
		if (!mdp.equals(conf)) {
			msgError = msgError + "Le mot de passe n'a pas été confirmer";
			session.setAttribute("error", msgError);
			errorInscription = true;
		}
		
		if (!errorInscription)
        {
			
			try {
				utilMana.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp, 0, 0);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("echec");
			}

            response.sendRedirect(request.getContextPath() + "/");
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
        		
        }
    }
	

}
