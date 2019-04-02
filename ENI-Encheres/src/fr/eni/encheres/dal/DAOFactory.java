package fr.eni.encheres.dal;

public abstract class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}

	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOjdbclmpl();
	}
	
	public static EncheresDAO getEncheresDAO() {
		return new EncheresDAOjdbclmpl();
	}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOjdbclmpl();
	}
}
