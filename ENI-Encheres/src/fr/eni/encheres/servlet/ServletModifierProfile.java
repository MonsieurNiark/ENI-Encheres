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
 * Servlet implementation class ServletModifierProfile
 */
@WebServlet("/modifierProfile")
public class ServletModifierProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      HttpSession session=request.getSession();
	      UtilisateurManager umgt = new UtilisateurManager();
	      if(request.getParameter("suppression") == null) {
	    	  try {
	  			Utilisateur actualUser = umgt.selectionnerUtilisateurByPseudo(session.getAttribute("actualUser").toString());
	  			session.setAttribute("pseudo_user", actualUser.getPseudo());
	  			session.setAttribute("nom", actualUser.getNom());
	  			session.setAttribute("prenom", actualUser.getPrenom());
	  			session.setAttribute("email", actualUser.getEmail());
	  			session.setAttribute("telephone", actualUser.getTelephone());
	  			session.setAttribute("code_postal", actualUser.getCodePostal());
	  			session.setAttribute("rue", actualUser.getRue());
	  			session.setAttribute("ville", actualUser.getVille());
	  			session.setAttribute("no_utilisateur", actualUser.getNoUtilisateur());
	  		} catch (BusinessException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	  		request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp").forward( request,  response);

	      } else {
		      System.out.println(request.getParameter("suppression").toString());
		      Utilisateur actualUser;
			try { //Suppression user
				actualUser = umgt.selectionnerUtilisateurByPseudo(session.getAttribute("actualUser").toString());
				try {
					umgt.supprimerUtilisateur(actualUser.getNoUtilisateur());
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward( request,  response);

	      }
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      HttpSession session=request.getSession();
	      UtilisateurManager umgt = new UtilisateurManager();
	      try {
	    	  
	    	  Utilisateur userCible = umgt.selectionnerUtilisateurByPseudo(session.getAttribute("actualUser").toString());
	    	  String nom = request.getParameter("nom").toString();
	    	  String prenom = request.getParameter("prenom").toString();
	    	  int no_utilisateur = (int) session.getAttribute("no_utilisateur");
	    	  String ville = request.getParameter("ville").toString();
	    	  String code_postal = request.getParameter("code_postal").toString();
	    	  String pseudo_user = session.getAttribute("pseudo_user").toString();
	    	  String rue = request.getParameter("rue").toString();
	    	  String email = request.getParameter("email").toString();
	    	  String telephone = request.getParameter("telephone").toString();
	    	  String motDePasse = request.getParameter("motDePasse").toString();
	    	  String oldMotDePasse = request.getParameter("oldMotDePasse").toString();
	    	  
	    	  System.out.println("before update");
	    	  if(motDePasse.equals(null) && oldMotDePasse.equals(userCible.getMotDePasse())) {
		    	  System.out.println("choix1");

		    	  System.out.println(oldMotDePasse);
		    	  System.out.println(motDePasse);

	    		  umgt.updateUtilisateur(no_utilisateur, pseudo_user, nom, prenom, email, telephone, rue, code_postal, ville, oldMotDePasse, userCible.getCredit(), userCible.getAdministrateur());
	    	  } else if (!motDePasse.equals(null) && oldMotDePasse.equals(userCible.getMotDePasse())){
		    	  System.out.println("choix2");
		    	  System.out.println(oldMotDePasse);
		    	  System.out.println(motDePasse);
	    		  umgt.updateUtilisateur(no_utilisateur, pseudo_user, nom, prenom, email, telephone, rue, code_postal, ville, motDePasse, userCible.getCredit(), userCible.getAdministrateur());
	    	  }
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
