package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ServletIndex
 */
@WebServlet("/index")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletIndex() {
		super();
		ArrayList<Categorie> liste = new ArrayList<Categorie>();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CategorieManager categMana  = new CategorieManager();
		ArrayList<Categorie> listeCategories = new ArrayList<Categorie>();

		ArticleVenduManager artMana = new ArticleVenduManager();
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();

		try {
			listeArticles = artMana.selectionnerArticles();
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			listeCategories = categMana.selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("articles", listeArticles);
		request.setAttribute("categories", listeCategories);

		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int idCateg =Integer.parseInt(request.getParameter("categorie"));
		String filtre = request.getParameter("recherche");
		String radioMenu = request.getParameter("radioMenu");
		String pseudo = (String) session.getAttribute("actualUser");
		CategorieManager categMana  = new CategorieManager();
		ArticleVenduManager artMana = new ArticleVenduManager();

		ArrayList<Categorie> listeCategories = new ArrayList<Categorie>();
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();

		if(session.getAttribute("isConnecte") == null) {
			if(idCateg == -1 && filtre.equals("")) {
				try {
					listeArticles = artMana.selectionnerArticles();
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {

				try {
					listeArticles = artMana.selectionnerParFiltre(idCateg, filtre+"%");
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if(session.getAttribute("isConnecte") != null) {

			if (radioMenu.equals("achats")) {
				if (request.getParameter("encheresOuvertes") != null) {
					request.setAttribute("enchereO", true);
					try {
						listeArticles = artMana.selectionnerParFiltre(idCateg, filtre+"%");
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (request.getParameter("encheresEnCours") != null) {
					request.setAttribute("enchereEC", true);
					if(idCateg == -1 && filtre.equals("")) {
						try {
							listeArticles = artMana.selectionnerMesEncheres(pseudo);
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {

						try {
							listeArticles = artMana.selectionnerParFiltre(idCateg, filtre+"%");
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				if (request.getParameter("encheresRemportees") != null) {
					request.setAttribute("enchereR", true);
				}
			} else if (radioMenu.equals("ventes")){
				if (request.getParameter("ventesNonDebutees") != null) {
					request.setAttribute("venteND", true);

				}
				if (request.getParameter("ventesEnCours") != null) {
					request.setAttribute("venteEC", true);
				}
				if (request.getParameter("ventesTerminees") != null) {
					request.setAttribute("venteT", true);
				}
			}
		}

		try {
			listeCategories = categMana.selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("categories", listeCategories);
		request.setAttribute("articles", listeArticles);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);

	}

}
