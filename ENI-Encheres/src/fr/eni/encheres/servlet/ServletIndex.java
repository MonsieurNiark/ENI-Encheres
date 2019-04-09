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
		int idCateg =Integer.parseInt(request.getParameter("categorie"));
		CategorieManager categMana  = new CategorieManager();
		ArrayList<Categorie> listeCategories = new ArrayList<Categorie>();
		ArticleVenduManager artMana = new ArticleVenduManager();
		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();
		
		try {
			listeCategories = categMana.selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listeArticles = artMana.selectionnerParIdCateg(idCateg);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("categories", listeCategories);
		request.setAttribute("articles", listeArticles);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	
	}

}
