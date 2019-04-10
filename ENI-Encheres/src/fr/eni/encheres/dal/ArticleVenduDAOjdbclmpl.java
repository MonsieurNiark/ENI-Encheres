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

	
	private static final String SELECT_ALL = "SELECT no_article, nom_article, description, date_debut_encheres, "
			+ "date_fin_encheres, prix_initial, prix_vente, ARTICLES_VENDUS.no_utilisateur, ARTICLES_VENDUS.no_categorie, "
			+ "CATEGORIES.no_categorie, libelle, UTILISATEURS.no_utilisateur, pseudo, nom, prenom, UTILISATEURS.email, UTILISATEURS.telephone, UTILISATEURS.rue,UTILISATEURS.code_postal,UTILISATEURS.ville,UTILISATEURS.mot_de_passe,UTILISATEURS.credit,UTILISATEURS.administrateur "
			+ "FROM ARTICLES_VENDUS "
			+ "INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie "
			+ "INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur ";
	
	private static final String SELECT_BY_NOM = SELECT_ALL + " WHERE nom_article=?";
	private static final String INSERT_VENTE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie ) VALUES(?,?,?,?,?,?,?,?);";
	private static final String DELETE_VENTE = "DELETE * FROM ARTICLES_VENDUS WHERE no_article=?";
	private static final String SELECT_BY_ID = SELECT_ALL + "WHERE no_article= ?";
	private static final String SELECT_BY_IDCATEG = "AND ARTICLES_VENDUS.no_categorie = ? ";
	private static final String SELECT_FILTRE = "AND ARTICLES_VENDUS.nom_article LIKE ? ";

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
			vnte.setInt(7, articlevendu.getUtilisateur().getNoUtilisateur());
			vnte.setInt(8, articlevendu.getCategorieArticle().getNoCategorie());

			vnte.executeUpdate();
			
			ResultSet rs = vnte.getGeneratedKeys();
			if(rs.next()) {
				articlevendu.setNoArticle(rs.getInt(1));
			}
		}
		catch(Exception e)//TODO remplacer par SQLException
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
	
	
	public List<ArticleVendu> selectParFiltre(int id, String recherche) throws BusinessException {
		List<ArticleVendu> articlevendu = new ArrayList<ArticleVendu>();
		String requete = null;
		String indice;
		
		if (id == -1 && !recherche.equals("")) { //ok
			requete =SELECT_ALL+"WHERE 1=1 " + SELECT_FILTRE;
			indice = "R";
		} else if(recherche.equals("%") && id != -1){
			requete = SELECT_ALL+"WHERE 1=1 " + SELECT_BY_IDCATEG;
			indice = "C";
		}else if(id == -1 && recherche.equals("%")){ //ok
			requete = SELECT_ALL;
			indice = "V";
		}else { 
			requete=SELECT_ALL+"WHERE 1=1 " + SELECT_BY_IDCATEG + SELECT_FILTRE;
			indice = "RC";
		}

		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(requete);
			switch(indice)
			{
				case "V":
					break;
				case "C":
					vnte.setInt(1, id);
					break;
				case "R":
					vnte.setString(1, recherche);
					break;
				case "RC":
					vnte.setInt(1, id);
					vnte.setString(2, recherche);
					break;
				default :
					System.out.println("Erreur d'affinage");
			}
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
	public ArticleVendu selectById(int id) throws BusinessException {
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
	
	
	@Override
	public ArticleVendu selectByIdArticle(int id) throws BusinessException {
		ArticleVendu result = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement vnte = cnx.prepareStatement(SELECT_BY_ID);
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
	

	
	
	
	public Utilisateur mappingUserArticle(ResultSet rs) throws SQLException {
		
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
	
	public Categorie mappingCategorieArticle(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("no_article");
		String libelle = rs.getString("libelle");
		
		return new Categorie(id,libelle);
	}
	
	private ArticleVendu map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		Date date_debut_encheres = rs.getDate("date_debut_encheres");
		Date date_fin_encheres = rs.getDate("date_fin_encheres");
		float prixinitial = rs.getFloat("prix_initial");
		float prixvente = rs.getFloat("prix_vente");
		Utilisateur util =  mappingUserArticle(rs);
		Categorie cat = mappingCategorieArticle(rs);
		return new ArticleVendu(id, nomArticle,description,date_debut_encheres,date_fin_encheres,prixinitial,prixvente,cat,util);
	}
	

}
