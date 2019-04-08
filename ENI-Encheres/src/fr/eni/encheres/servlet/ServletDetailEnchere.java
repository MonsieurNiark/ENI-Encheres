package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait;

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
		try {
			ArticleVendu article = amgt.selectionnerParId(idArticle);
			String nomArticle = article.getNomArticle();
			String descArticle = article.getDescription();
			String categorie = article.getCategorieArticle().getLibelle();
			float prixInit = article.getMiseAPrix();
			float prixVente = article.getPrixVente();
			Date finEnchere = article.getDateFinEncheres();
			Retrait retrait = rmgt.selectionnerRetrait(idArticle);
			String lieuRetrait = retrait.getRue() + " " + retrait.getCode_postal() + " " + retrait.getVille();
			String vendeur = article.getUtilisateur().getPseudo();
			System.out.println(nomArticle);
			System.out.println(descArticle);
			System.out.println(categorie);
			System.out.println(prixInit);
			System.out.println(prixVente);
			System.out.println(finEnchere);
			System.out.println(lieuRetrait);
			System.out.println(vendeur);
			request.setAttribute("nomArticle", nomArticle);
			request.setAttribute("descArticle", descArticle);
			request.setAttribute("categorie", categorie);
			request.setAttribute("prixInit",prixInit );
			request.setAttribute("prixVente", prixVente);
			request.setAttribute("finEnchere",finEnchere );
			request.setAttribute("lieuRetrait",lieuRetrait );
			request.setAttribute("vendeur",vendeur );
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
		doGet(request, response);
	}

}
