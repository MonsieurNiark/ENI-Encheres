package fr.eni.encheres.test.robyn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/testRobyn")
public class TestDal extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	EnchereManager emgt = new EnchereManager();
    	List<Enchere> listEn = new ArrayList<Enchere>();
    	
    	
    	try {
    		listEn = emgt.selectLastEnchereForeachUserArticle(1);
			for(Enchere enchere : listEn) {
				System.out.println(enchere.getUtilisateur().getPseudo()+" "+enchere.getMontant_enchere());
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	super.doGet(req, resp);
    }
}
