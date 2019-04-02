package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;

public class EncheresDAOjdbclmpl implements EncheresDAO{

	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private static final String SELECT_BY_USER = SELECT_ALL + " WHERE no_utilisateur=?";
	private static final String SELECT_BY_ARTICLE = SELECT_ALL + " WHERE no_article=?";
	private static final String INSERT_VENTE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie ) VALUES(?,?,?,?,?,?,?,?);";
	private static final String DELETE_VENTE = "DELETE * FROM ARTICLES_VENDUS WHERE no_article=?";
	
	@Override
	public void insert(Enchere enchere) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere selectByNom(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
