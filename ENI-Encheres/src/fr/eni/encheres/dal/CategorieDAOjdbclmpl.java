package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;

public class CategorieDAOjdbclmpl implements CategorieDAO {
	
	private static final String SELECT_CATEGORIE_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie=?";
	private static final String INSERT_CATEGORIE = "INSERT INTO CATEGORIES() VALUES(?,?,?);";
	private static final String DELETE_CATEGORIE = "DELETE * FROM CATEGORIES WHERE no_categorie=?";
	
	@Override
	public void insert(Categorie categorie) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorie selectById(int id) throws BusinessException {
		Categorie result = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(SELECT_CATEGORIE_BY_ID);
			vnte.setInt(1, id);
			ResultSet rs = vnte.executeQuery();
			if(rs.next()) {
				result = map(rs);
			}
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		}
		
		if(result == null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_INEXISTANTE);
			throw businessException;
		}
		
		return result;
	}
	
	private Categorie map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("no_article");
		String libelle = rs.getString("libelle");
		
		return new Categorie(id,libelle);
	}

}
