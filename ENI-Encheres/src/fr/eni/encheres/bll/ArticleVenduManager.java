package fr.eni.encheres.bll;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleVenduManager {

	private ArticleVenduDAO articlevenduDAO;
	   
	public ArticleVenduManager() {
		articlevenduDAO = DAOFactory.getArticleVenduDAO();
	}
	
	public List<ArticleVendu> selectionnerArticles() throws BusinessException {
		return articlevenduDAO.selectAll();
	}
	
	public List<ArticleVendu> selectionnerParFiltre(int id, String recherche) throws BusinessException {
		return articlevenduDAO.selectParFiltre(id, recherche);
	}
	
	public List<ArticleVendu> selectionnerListeParId(int id) throws BusinessException {
		return articlevenduDAO.selectListByIdArticle(id);
	}
	
	public List<ArticleVendu> selectListByUser(String pseudo) throws BusinessException {
		return articlevenduDAO.selectListByUser(pseudo);
	}
	
	public List<ArticleVendu> selectListEtat(String pseudo) throws BusinessException {
		return articlevenduDAO.selectListEtat(pseudo);
	}
	
	public ArticleVendu selectionnerParIdUser(int Id) throws BusinessException{
		return articlevenduDAO.selectById(Id);
	}
	
	public void supprimerArticle(int Id) throws BusinessException{
		articlevenduDAO.delete(Id);
	}
	
	public ArticleVendu insererArticle(String nomArticle,String description,Date date_debut_encheres,Date date_fin_encheres,float prixinitial,float prixvente,Utilisateur util,Categorie cat) throws BusinessException{
		ArticleVendu articlevendu = new ArticleVendu(nomArticle,description,date_debut_encheres,date_fin_encheres,prixinitial,prixvente,cat,util);
		articlevenduDAO.insert(articlevendu);
		return articlevendu;
	}
	
	public ArticleVendu selectionnerParId(int id) throws BusinessException {
		return articlevenduDAO.selectByIdArticle(id);
	}
	
	public List<ArticleVendu> selectParId(int id) throws BusinessException {
		return articlevenduDAO.selectListByIdArticle(id);
	}
	
	public ArticleVendu selectParLastNom(String nom) throws BusinessException {
		return articlevenduDAO.selectByLastNomArticle(nom);
	}
	
	
}
