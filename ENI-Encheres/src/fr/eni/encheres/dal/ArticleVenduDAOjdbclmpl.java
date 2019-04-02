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
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bo.Categorie;




public class ArticleVenduDAOjdbclmpl implements ArticleVenduDAO{

	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private static final String SELECT_BY_NOM = SELECT_ALL + " WHERE nom_article=?";
	private static final String INSERT_VENTE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie ) VALUES(?,?,?,?,?,?,?,?);";
	private static final String DELETE_VENTE = "DELETE * FROM ARTICLES_VENDUS WHERE no_article=?";

	@Override
	public void insert(ArticleVendu articlevendu) throws BusinessException {
		if(articlevendu==null)
		{
			BusinessException businessException = new BusinessException();
			//TODO : CodesResultatDAL
			//businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(INSERT_VENTE, PreparedStatement.RETURN_GENERATED_KEYS);			
			vnte.setString(1, articlevendu.getNomArticle());
			vnte.setString(2, articlevendu.getDescription());
			vnte.setDate(3, (java.sql.Date) articlevendu.getDateDebutEncheres());
			vnte.setDate(4, (java.sql.Date) articlevendu.getDateFinEncheres());
			vnte.setFloat(5, articlevendu.getMiseAPrix());
			vnte.setFloat(6, articlevendu.getPrixVente());
			vnte.setInt(7, articlevendu.getCategorieArticle().getNoCategorie());
			vnte.setInt(8, articlevendu.getCategorieArticle().getNoCategorie());

			vnte.executeUpdate();
			
			ResultSet rs = vnte.getGeneratedKeys();
			if(rs.next()) {
				articlevendu.setNoArticle(rs.getInt(1));
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
	public List<ArticleVendu> selectAll() throws BusinessException {
		List<ArticleVendu> articlevendu = new ArrayList<ArticleVendu>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = vnte.executeQuery();
			while(rs.next())
			{
				articlevendu.add(map(rs));
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
		return articlevendu;
	}
	
	@Override
	public ArticleVendu selectByNom(int id) throws BusinessException {
		ArticleVendu result = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(SELECT_BY_NOM);
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
	
private ArticleVendu map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		Date date_debut_encheres = rs.getDate("date_debut_encheres");
		Date date_fin_encheres = rs.getDate("date_fin_encheres");
		float prixinitial = rs.getFloat("prix_initial");
		float prixvente = rs.getFloat("prix_vente");
		int no_utilisateur = rs.getInt("no_utilisateur");
		Utilisateur util = ;  
		int no_categorie = rs.getInt("no_categorie");
		Categorie cat = ; 
		return ArticleVendu(id, nomArticle,description,date_debut_encheres,date_fin_encheres,prixinitial,prixvente,cat,util);
	}
}
