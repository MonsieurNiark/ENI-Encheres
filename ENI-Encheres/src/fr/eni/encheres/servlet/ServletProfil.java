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


@WebServlet("/profile")
public class ServletProfil extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtilisateurManager utilMgt = new UtilisateurManager();
	      HttpSession session= req.getSession();
	      if(session.getAttribute("actualUser") == null) {
	    	  session.setAttribute("actualUser", " ");
	      }
			Utilisateur user = null;
			try {
				user = utilMgt.selectionnerUtilisateurByPseudo(req.getParameter("user"));
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				System.out.println("IN ERROR");
				req.setAttribute("pseudoUser", "LE PROFILE N'EXISTE PAS");
				req.setAttribute("nom", " ");
				req.setAttribute("prenom", " ");
				req.setAttribute("email", " ");
				req.setAttribute("telephone", " ");
				req.setAttribute("code_postal", " ");
				req.setAttribute("rue", " ");
				req.setAttribute("ville", " ");
				String divCredit = new String("<h4>Crédit : </h4>");
				req.setAttribute("credit", divCredit);
				
				user = null;
			}
			if(user != null) {
				
				req.setAttribute("pseudoUser", user.getPseudo().toString());
				req.setAttribute("nom", user.getNom());
				req.setAttribute("prenom", user.getPrenom());
				req.setAttribute("email", user.getEmail());
				req.setAttribute("telephone", user.getTelephone());
				req.setAttribute("code_postal", user.getCodePostal());
				req.setAttribute("rue", user.getRue());
				req.setAttribute("ville", user.getVille());
				String divCredit = new String("<h4>Crédit : "+user.getCredit()+"</h4>");
				req.setAttribute("credit", divCredit);
			} else {
				req.getRequestDispatcher("./ENI-Encheres/connexion");
			}
		req.getRequestDispatcher("/WEB-INF/jsp/afficherProfil.jsp").forward( req,  resp);
	}
	
}