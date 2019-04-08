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
	private static final String SELECT_LAST_ENCHERE = "SELECT * FROM ENCHERES WHERE no_article=? AND montant_enchere = (SELECT max(montant_enchere) FROM encheres)";
	
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
	
	
	@Override
	public Enchere selectLastEnchereByArticle(int id) throws BusinessException {
		Enchere result = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(SELECT_LAST_ENCHERE);
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
	
	public Utilisateur mappingUserEnchere(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("no_utilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String code_postal = rs.getString("code_postal");
		String ville = rs.getString("ville");
		String mot_de_passe = rs.getString("mot_de_passe");
		int credit = rs.getInt("credit");
		int administrateur = rs.getInt("administrateur");
		return new Utilisateur(id, pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur);
	}
	
	public Categorie mappingCategorieEnchere(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("no_article");
		String libelle = rs.getString("libelle");
		
		return new Categorie(id,libelle);
	}
	
	public ArticleVendu mapArticleEnchere(ResultSet rs) throws SQLException {
	
		int id = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		Date date_debut_encheres = rs.getDate("date_debut_encheres");
		Date date_fin_encheres = rs.getDate("date_fin_encheres");
		float prixinitial = rs.getFloat("prix_initial");
		float prixvente = rs.getFloat("prix_vente");
		Utilisateur util =  mappingUserEnchere(rs);
		Categorie cat = mappingCategorieEnchere(rs);
		return new ArticleVendu(id, nomArticle,description,date_debut_encheres,date_fin_encheres,prixinitial,prixvente,cat,util);
	}

	private Enchere map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("no_enchere");
		Date date_enchere = rs.getDate("date_enchere");
		float montant_enchere = rs.getFloat("montant_enchere");
		Utilisateur util =  mappingUserEnchere(rs);
		ArticleVendu Art = mapArticleEnchere(rs);
		return new Enchere(id, date_enchere,montant_enchere,util,Art);
	}
	


}
