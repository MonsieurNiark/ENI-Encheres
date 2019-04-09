package fr.eni.encheres.bo;

import java.util.Date;

public class Enchere {

// *************************************************************************************
// CHAMPS
// *************************************************************************************
	
	private int noEnchere;
	private Date dateEnchere;
	private float montant_enchere;
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;
	
	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 */
// *************************************************************************************
// CONSTRUCTEURS
// *************************************************************************************	
	public Enchere(Date dateEnchere, float montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}
	
	public Enchere(int noEnchere, Date dateEnchere, float montant_enchere, Utilisateur utilisateur,
			ArticleVendu articleVendu) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}
	
	public Enchere(Date dateEnchere, float montant_enchere, Utilisateur utilisateur,
			ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}
// *************************************************************************************
// GETTERS
// *************************************************************************************
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public float getMontant_enchere() {
		return montant_enchere;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	public int getNoEnchere() {
		return noEnchere;
	}
// *************************************************************************************
// CONSTRUCTEURS
// *************************************************************************************
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public void setMontant_enchere(float montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	
}
