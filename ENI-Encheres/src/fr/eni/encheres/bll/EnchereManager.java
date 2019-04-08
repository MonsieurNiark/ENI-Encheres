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
	
	public Enchere selectionnerEnchereParIdUser(int IdUser) throws BusinessException{
		return encheresDAO.selectByUser(IdUser);
	}
	
	public Enchere selectionnerEnchereParIdArticle(int IdArticle) throws BusinessException{
		return encheresDAO.selectByArticle(IdArticle);
	}
	
	public void supprimerEnchere(int id) throws BusinessException{
		encheresDAO.delete(id);
	}
	
	public Enchere selectionnerLastEnchereParIdArticle(int idArticle) throws BusinessException{
		return encheresDAO.selectLastEnchereByArticle(idArticle);
	}
	
	
	public Enchere insererEnchere(int id, Date date_enchere, float montant_enchere, Utilisateur util, ArticleVendu art) throws BusinessException{
		Enchere nouvelEnchere = new Enchere(id, date_enchere, montant_enchere, util, art);
		encheresDAO.insert(nouvelEnchere);
		return nouvelEnchere;
	}
}
