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
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/testRobyn")
public class TestDal extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	UtilisateurManager utilisateurManager = new UtilisateurManager();
    	int idManager = 0;
    	List<Utilisateur> listUt = new ArrayList<Utilisateur>();
    	try {
			listUt = utilisateurManager.selectionnerUtilisateurs();
			for(Utilisateur utilisateur : listUt) {
				System.out.println(utilisateur.getNom().toString()+" "+utilisateur.getPrenom());
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	super.doGet(req, resp);
    }
}
