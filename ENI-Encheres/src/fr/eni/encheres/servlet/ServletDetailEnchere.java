package fr.eni.encheres.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletDetailEnchere
 */
@WebServlet("/enchere")
public class ServletDetailEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idArticle;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetailEnchere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			idArticle = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println("ID doit etre un nombre");
		}
		ArticleVenduManager amgt = new ArticleVenduManager();
		RetraitManager rmgt = new RetraitManager();
		EnchereManager emgt = new EnchereManager();
		try {
			//Recuperation des infos Article
			ArticleVendu article = amgt.selectionnerParId(idArticle);
			String nomArticle = article.getNomArticle();
			String descArticle = article.getDescription();
			String categorie = article.getCategorieArticle().getLibelle();
			float prixInit = article.getMiseAPrix();
			float prixVente = article.getPrixVente();
			String finEnchere = article.getDateFinEncheres().toString();
			String vendeur = article.getUtilisateur().getPseudo();
			//Récupération des infos Retrait
			Retrait retrait = rmgt.selectionnerRetrait(idArticle);
			String lieuRetrait = retrait.getRue() + " " + retrait.getCode_postal() + " " + retrait.getVille();
			//Récupération des infos Enchérissement Enchere
			Enchere enchere = emgt.selectionnerLastEnchereParIdArticle(idArticle);
			float lastPriceEnchere = enchere.getMontant_enchere();
			String lastNameEnchere = enchere.getUtilisateur().getPseudo();
			request.setAttribute("nomArticle", nomArticle);
			request.setAttribute("descArticle", descArticle);
			request.setAttribute("categorie", categorie);
			request.setAttribute("prixInit",prixInit );
			request.setAttribute("prixVente", prixVente);
			request.setAttribute("finEnchere",finEnchere );
			request.setAttribute("lieuRetrait",lieuRetrait );
			request.setAttribute("vendeur",vendeur );
			request.setAttribute("lastNameEnchere", lastNameEnchere);
			request.setAttribute("lastPriceEnchere", lastPriceEnchere);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		request.getRequestDispatcher("/WEB-INF/jsp/encherir.jsp").forward( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      HttpSession session= request.getSession();

		try{
			idArticle = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println("ID doit etre un nombre");
		}
		float creditProp = Float.valueOf(request.getParameter("creditProp"));
		System.out.println(creditProp);
		ArticleVenduManager amgt = new ArticleVenduManager();
		RetraitManager rmgt = new RetraitManager();
		EnchereManager emgt = new EnchereManager();
		UtilisateurManager umgt = new UtilisateurManager();
		try {
			String actualUser = session.getAttribute("actualUser").toString();
			Utilisateur actualUserInstance = umgt.selectionnerUtilisateurByPseudo(actualUser);
			//Recuperation des infos Article
			ArticleVendu article = amgt.selectionnerParId(idArticle);
			String nomArticle = article.getNomArticle();
			String descArticle = article.getDescription();
			String categorie = article.getCategorieArticle().getLibelle();
			float prixInit = article.getMiseAPrix();
			float prixVente = article.getPrixVente();
			String finEnchere = article.getDateFinEncheres().toString();
			String vendeur = article.getUtilisateur().getPseudo();
			//Récupération des infos Retrait
			Retrait retrait = rmgt.selectionnerRetrait(idArticle);
			String lieuRetrait = retrait.getRue() + " " + retrait.getCode_postal() + " " + retrait.getVille();
			//Récupération des infos Enchérissement Enchere
			Enchere enchere = emgt.selectionnerLastEnchereParIdArticle(idArticle);
			float lastPriceEnchere = enchere.getMontant_enchere();
			String lastNameEnchere = enchere.getUtilisateur().getPseudo();

			if(creditProp > lastPriceEnchere) {
				emgt.insererEnchere(java.sql.Date.valueOf(finEnchere), creditProp, actualUserInstance, article);
			}
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
