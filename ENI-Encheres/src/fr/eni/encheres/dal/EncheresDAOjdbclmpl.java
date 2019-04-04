package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bll.UtilisateurManager;

public class EncheresDAOjdbclmpl implements EncheresDAO{

	private static final String SELECT_ALL = "SELECT * FROM ENCHERES";
	private static final String SELECT_BY_USER = SELECT_ALL + " WHERE no_utilisateur=?";
	private static final String SELECT_BY_ARTICLE = SELECT_ALL + " WHERE no_article=?";
	private static final String INSERT_VENTE = "INSERT INTO ENCHERES(no_utilisateur,no_article,date_enchere,montant_enchere) VALUES(?,?,?,?);";
	private static final String DELETE_VENTE = "DELETE * FROM ENCHERES WHERE no_enchere=?";
	
	@Override
	public void insert(Enchere enchere) throws BusinessException {
		if(enchere==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(INSERT_VENTE, PreparedStatement.RETURN_GENERATED_KEYS);			
			vnte.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			vnte.setInt(2, enchere.getArticleVendu().getNoArticle());
			vnte.setDate(3, (java.sql.Date) enchere.getDateEnchere());
			vnte.setFloat(4, enchere.getMontant_enchere());


			vnte.executeUpdate();
			
			ResultSet rs = vnte.getGeneratedKeys();
			if(rs.next()) {
				enchere.setNoEnchere(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void delete(int id) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(DELETE_VENTE);
			vnte.setInt(1, id);
			vnte.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			throw businessException;
		}
		
	}

	@Override
	public List<Enchere> selectAll() throws BusinessException {
		List<Enchere> enchere = new ArrayList<Enchere>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = vnte.executeQuery();
			while(rs.next())
			{
				enchere.add(map(rs));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}
		return enchere;
	}
	@Override
	public Enchere selectByUser(int id) throws BusinessException {
		Enchere result = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(SELECT_BY_USER);
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

	@Override
	public Enchere selectByArticle(int id) throws BusinessException {
		Enchere result = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(SELECT_BY_ARTICLE);
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
	


}
