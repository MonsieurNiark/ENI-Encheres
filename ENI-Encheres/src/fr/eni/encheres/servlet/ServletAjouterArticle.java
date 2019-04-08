package fr.eni.encheres.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjoutArticle")
public class ServletAjouterArticle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/jsp/ajouterArticle.jsp").forward( req,  resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String NomArt = req.getParameter("Article");
		String Cat = req.getParameter("Catégorie");
		String Prix = req.getParameter("Prix");
		String Date1 = req.getParameter("DateDebut");
		String Date2 = req.getParameter("DateFin");
		String rue = req.getParameter("Rue");
		String ville = req.getParameter("Ville");
		String CodePost = req.getParameter("CodePostal");
		
		SimpleDateFormat First = null;
		SimpleDateFormat Second = null;

	}
	
}
