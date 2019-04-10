package fr.eni.encheres.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/AjoutArticle")
public class ServletAjouterArticle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/jsp/ajouterArticle.jsp").forward( req,  resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		UtilisateurManager umgt = new UtilisateurManager(); 
		ArticleVenduManager vnte = new ArticleVenduManager();
		CategorieManager cte = new CategorieManager();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Utilisateur userCible = umgt.selectionnerUtilisateurByPseudo(session.getAttribute("actualUser").toString());
			String NomArt = req.getParameter("Article");
			String Desc = req.getParameter("Desc");
			String Cat = req.getParameter("Cat�gorie");
			int CatNumber = Integer.parseInt(Cat);	
			Categorie catCible = cte.selectionnerCategorieById(CatNumber);
			String Prix = req.getParameter("Prix");
			float PrixNumber = Float.parseFloat(Prix);
			float PrixVente = 0;
			
			//R�cuperation des dates sur la page jsp
			String Date1 = req.getParameter("DateDebut");
			String Date2 = req.getParameter("DateFin");
			//Transformer les date pour etre ins�rer dans le format sql DATE
			Date date1 = null;
			try {
				date1 = formatter.parse(Date1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Date date2 = null;
			try {
				date2 = formatter.parse(Date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String rue = req.getParameter("Rue");
			String ville = req.getParameter("Ville");
			String CodePost = req.getParameter("CodePostal");

			
			vnte.insererArticle(NomArt, Desc, date1, date2, PrixNumber, PrixVente, userCible, catCible);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(req, resp);
	}
	
}
