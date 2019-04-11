package fr.eni.encheres.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bo.ArticleVendu;

@WebServlet("/AjoutArticle")
public class ServletAjouterArticle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategorieManager categMana  = new CategorieManager();
		ArrayList<Categorie> listeCategories = new ArrayList<Categorie>();
		
		try {
			listeCategories = categMana.selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("categories", listeCategories);
		
		req.getRequestDispatcher("/WEB-INF/jsp/ajouterArticle.jsp").forward( req,  resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		UtilisateurManager umgt = new UtilisateurManager(); 
		ArticleVenduManager vmgt = new ArticleVenduManager();
		CategorieManager cmgt = new CategorieManager();
		RetraitManager rmgt = new RetraitManager();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Utilisateur userCible = umgt.selectionnerUtilisateurByPseudo(session.getAttribute("actualUser").toString());
			String NomArt = req.getParameter("Article");
			String Desc = req.getParameter("Desc");
			String Cat = req.getParameter("categorie");
			System.out.println(Cat);
			int CatNumber = Integer.parseInt(Cat);
			System.out.println(CatNumber);
			Categorie catCible = cmgt.selectionnerCategorieById(CatNumber);
			String Prix = req.getParameter("Prix");
			float PrixNumber = Float.parseFloat(Prix);
			float PrixVente = 0;
			
			System.out.println(NomArt);
			System.out.println(Desc);
			
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
			java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
			
			System.out.println(sqlDate1);
			
		    Date date2 = null;
			try {
				date2 = formatter.parse(Date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
			
			System.out.println(sqlDate2);

			String rue = req.getParameter("Rue");
			String ville = req.getParameter("Ville");
			String CodePost = req.getParameter("CodePostal");

			
			vmgt.insererArticle(NomArt, Desc, sqlDate1, sqlDate2, PrixNumber, PrixVente, userCible, catCible);
			
			ArticleVendu Art = vmgt.selectParLastNom(NomArt);
			
			rmgt.ajouterRetrait(Art, rue, CodePost, ville);
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/jsp/ajouterArticle.jsp").forward( req,  resp);
	}
	
}
