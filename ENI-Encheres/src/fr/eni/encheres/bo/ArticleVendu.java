package fr.eni.encheres.bo;

import java.util.Date;

public class ArticleVendu {
	
// *************************************************************************************
// CHAMPS
// *************************************************************************************
	
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private float miseAPrix;
	private float prixVente;
	private String etatVente;
	private Utilisateur utilisateur;
	private Categorie categorieArticle;
	private Retrait lieuRetrait;
	
	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param categorieArticle
	 * @param lieuRetrait
	 */
	
// *************************************************************************************
// CONSTRUCTEURS
// *************************************************************************************
	
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, float miseAPrix, float prixVente, String etatVente, Categorie categorieArticle,
			Retrait lieuRetrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorieArticle = categorieArticle;
		this.lieuRetrait = lieuRetrait;
	}
	
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, float miseAPrix, float prixVente, Categorie categorieArticle, Utilisateur utilisateur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.categorieArticle = categorieArticle;
		this.utilisateur = utilisateur;

	}
	
// *************************************************************************************
// GETTERS
// *************************************************************************************
	
	public int getNoArticle() {
		return noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}
	public float getMiseAPrix() {
		return miseAPrix;
	}
	public float getPrixVente() {
		return prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public Categorie getCategorieArticle() {
		return this.categorieArticle;
	}
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

// *************************************************************************************
// SETTERS
// *************************************************************************************
	
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public void setMiseAPrix(float miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public void setPrixVente(float prixVente) {
		this.prixVente = prixVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
