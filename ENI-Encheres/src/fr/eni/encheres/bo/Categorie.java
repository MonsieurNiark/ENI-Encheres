package fr.eni.encheres.bo;

public class Categorie {
	
// *************************************************************************************
// CHAMPS
// *************************************************************************************
	
	private int noCategorie;
	private String libelle;
	/**
	 * @param noCategorie
	 * @param libelle
	 */
// *************************************************************************************
// CONSTRUCTEURS
// *************************************************************************************
	
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
// *************************************************************************************
// GETTERS
// *************************************************************************************
	public int getNoCategorie() {
		return noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
// *************************************************************************************
// SETTERS
// *************************************************************************************	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	
}
