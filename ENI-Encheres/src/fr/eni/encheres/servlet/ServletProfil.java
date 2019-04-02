package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		try {
			Utilisateur user = utilMgt.selectionnerUtilisateurByPseudo(req.getParameter("user"));
			System.out.println(user.getNom());
			System.out.println(user.getPrenom());
			System.out.println(user.getPseudo());
			req.setAttribute("pseudo_user", user.getPseudo().toString());
			req.setAttribute("nom", user.getNom());
			req.setAttribute("prenom", user.getPrenom());
			req.setAttribute("email", user.getEmail());
			req.setAttribute("telephone", user.getTelephone());
			req.setAttribute("code_postal", user.getCodePostal());
			req.setAttribute("rue", user.getRue());
			req.setAttribute("ville", user.getVille());
			
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/jsp/afficherProfil.jsp").forward( req,  resp);
	}
	
}