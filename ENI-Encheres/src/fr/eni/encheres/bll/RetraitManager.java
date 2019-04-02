package fr.eni.encheres.bll;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;

public class RetraitManager {

	private RetraitDAO retraitDAO;
	
	public RetraitManager() {
		retraitDAO = DAOFactory.getRetraitDAO();
	}
	
	public Retrait selectionnerRetrait(int idRetrait) throws BusinessException {
		return retraitDAO.selectById(idRetrait);
	}
	
	public Retrait ajouterRetrait(int no_article, String rue, String code_postal, String ville) throws BusinessException {
		Retrait nouveauRetrait = new Retrait(no_article, rue, code_postal, ville);
		retraitDAO.insert(nouveauRetrait);
		return nouveauRetrait;
	}
	
	public void supprimerRetrait(int no_article) throws BusinessException{
		retraitDAO.delete(no_article);
	}
	
	public void updateRetrait(int no_article, String rue, String code_postal, String ville) throws BusinessException {
		Retrait retraitAModifier = new Retrait(no_article, rue, code_postal, ville);
		retraitDAO.update(retraitAModifier);
	}
}
