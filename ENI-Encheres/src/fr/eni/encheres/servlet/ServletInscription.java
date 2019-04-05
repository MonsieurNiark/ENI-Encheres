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

/**
 * Servlet implementation class ServletInscirption
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if(session.getAttribute("isConnecte") == null)
		{
			request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward( request,  response);
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
		int nbUser = 0;
		int nbEmail = 0;
		boolean pseudoFormat = false;
		boolean errorInscription= false;
		UtilisateurManager utilMana  = new UtilisateurManager();
		try {
			nbUser =  utilMana.countByPseudo(pseudo);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		pseudoFormat = utilMana.isPseudoFormatOk(pseudo);
		
		if(!pseudoFormat) {
			msgError = "Le pseudo n'accepte seulement que les caractères alphanumérique";
			request.setAttribute("error", msgError);
			errorInscription = true;
		}
		
	
		if(nbUser > 0) {
			msgError =msgError + "Pseudo déjà utilisé";
			request.setAttribute("error", msgError);
			errorInscription = true;
		}
		
		if(nbEmail > 0) {
			msgError = msgError + "Email déjà utilisé";
			request.setAttribute("error", msgError);
			errorInscription = true;
		}
		
		if(pseudo.equals("") || nom.equals("") || prenom.equals("") || email.equals("") || telephone.equals("") ||
				rue.equals("")|| ville.equals("")|| mdp.equals("") || conf.equals("")) {
			
			msgError = msgError + "Certains champs n'ont pas été renseignés";
			request.setAttribute("error", msgError);
			errorInscription = true;
		}
		
		if (!mdp.equals(conf)) {
			msgError = msgError + "Le mot de passe n'a pas été confirmer";
			request.setAttribute("error", msgError);
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

            response.sendRedirect(request.getContextPath() + "/index");
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
        		
        }
    }
	

}
