package fr.eni.encheres.bll;

import java.util.List;
import java.util.Date;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EncheresDAO;

public class EnchereManager {

	private EncheresDAO encheresDAO;
	
	public EnchereManager() {
		encheresDAO = DAOFactory.getEncheresDAO();
	}
	
	public List<Enchere> selectionnerEnchere() throws BusinessException {
		return encheresDAO.selectAll();
	}
	
	public List<Enchere> selectLastEnchereForeachUserArticle(int idArticle) throws BusinessException{
		return encheresDAO.selectLastEnchereForEachUser(idArticle);
	}
	
	public List<Integer> selectEnchereUser(int noUser) throws BusinessException {
		return encheresDAO.selectEnchereUser(noUser);
	}
	
	public Enchere selectionnerEnchereParIdUser(int idUser) throws BusinessException{
		return encheresDAO.selectByUser(idUser);
	}
	
	public Enchere selectionnerEnchereParIdArticle(int idArticle) throws BusinessException{
		return encheresDAO.selectByArticle(idArticle);
	}
	
	public Enchere selectionnerEnchereParIdArticleAnduser(int idArticle, int idUser) throws BusinessException{
		return encheresDAO.selectLastEnchereByArticleAndUser(idArticle, idUser);
	}
	
	public void supprimerEnchere(int id) throws BusinessException{
		encheresDAO.delete(id);
	}
	
	public Enchere selectionnerLastEnchereParIdArticle(int idArticle) throws BusinessException{
		return encheresDAO.selectLastEnchereByArticle(idArticle);
	}
	
	
	public Enchere insererEnchere(Date date_enchere, float montant_enchere, Utilisateur util, ArticleVendu art) throws BusinessException{
		Enchere nouvelEnchere = new Enchere(date_enchere, montant_enchere, util, art);
		encheresDAO.insert(nouvelEnchere);
		return nouvelEnchere;
	}
}
