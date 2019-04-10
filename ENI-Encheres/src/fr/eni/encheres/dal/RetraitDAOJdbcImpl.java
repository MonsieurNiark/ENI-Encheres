package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

public class RetraitDAOJdbcImpl implements RetraitDAO {

	private static final String SELECT_ALL = "SELECT RETRAITS.no_retrait, RETRAITS.no_article, rue, code_postal, ville,"
			+ " ARTICLES_VENDUS.no_article, nom_article, description, date_debut_encheres , date_fin_encheres, prix_initial,"
			+ " prix_vente, ARTICLES_VENDUS.no_utilisateur, ARTICLES_VENDUS.no_categorie, ETAT FROM RETRAITS";

	private static final String SELECT_BY_ID = SELECT_ALL + " WHERE no_article=?";

	private static final String INSERT_RETRAIT = "INSERT INTO RETRAITS(no_retrait ,no_article,rue,code_postal,ville) VALUES(?,?,?,?,?);";

	private static final String DELETE_RETRAIT = "DELETE FROM RETRAITS WHERE no_article=?";

	private static final String UPDATE_RETRAIT = "UPDATE RETRAITS set rue=?,code_postal=?,ville=? WHERE no_article=?";

	public void insert(Retrait retrait) throws BusinessException {
		if (retrait == null) {
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, retrait.getNo_retrait());
			pstmt.setInt(2, retrait.getNo_article().getNoArticle());
			pstmt.setString(3, retrait.getRue());
			pstmt.setString(4, retrait.getCode_postal());
			pstmt.setString(5, retrait.getVille());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				retrait.setNo_retrait(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void delete(int id) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_RETRAIT);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_LISTE_ERREUR);
			throw businessException;
		}

	}

	@Override
	public Retrait selectById(int id) throws BusinessException {
		Retrait result = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = map(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		}

		if (result == null) {
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_INEXISTANTE);
			throw businessException;
		}

		return result;
	}

	@Override
	public void update(Retrait retrait) throws BusinessException {
		if (retrait == null) {
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_RETRAIT);

			pstmt.setString(1, retrait.getRue());
			pstmt.setString(2, retrait.getCode_postal());
			pstmt.setString(3, retrait.getVille());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			// TODO : CodesResultatDAL
			// businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	private Utilisateur mapUtilisateurRetrait(ResultSet rs) throws SQLException {

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
		return new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,
				administrateur);
	}

	private Categorie mapCategorieRetrait(ResultSet rs) throws SQLException {

		int id = rs.getInt("no_article");
		String libelle = rs.getString("libelle");

		return new Categorie(id, libelle);
	}

	private ArticleVendu mapArticleVenduRetrait(ResultSet rs) throws SQLException {

		int id = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		Date date_debut_encheres = rs.getDate("date_debut_encheres");
		Date date_fin_encheres = rs.getDate("date_fin_encheres");
		float prixinitial = rs.getFloat("prix_initial");
		float prixvente = rs.getFloat("prix_vente");
		Utilisateur util = mapUtilisateurRetrait(rs);
		Categorie cat = mapCategorieRetrait(rs);
		return new ArticleVendu(id, nomArticle, description, date_debut_encheres, date_fin_encheres, prixinitial,
				prixvente, cat, util);
	}

	private Retrait map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("no_retrait");
		ArticleVendu Art = mapArticleVenduRetrait(rs);
		String rue = rs.getString("rue");
		String code_postal = rs.getString("code_postal");
		String ville = rs.getString("ville");
		return new Retrait(id, Art, rue, code_postal, ville);
	}

}
