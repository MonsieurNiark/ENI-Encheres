package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.CategorieDAO;


public class CategorieManager {

	private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	public Categorie selectionnerCategorieById(int idCat) throws BusinessException {
		return categorieDAO.selectById(idCat);
	}
	
	public List<Categorie> selectAll() throws BusinessException {
		return categorieDAO.selectAll();
	}

}
