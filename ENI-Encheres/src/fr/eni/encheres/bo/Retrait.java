package fr.eni.encheres.bo;

public class Retrait {
// *************************************************************************************
// CHAMPS
// *************************************************************************************
	private int no_article;
	private String rue;
	private String code_postal;
	private String ville;
	/**
	 * @param rue
	 * @param code_postal
	 * @param ville
	 */
// *************************************************************************************
// CONSTRUCTEURS
// *************************************************************************************
	public Retrait(int no_article,String rue, String code_postal, String ville) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.no_article = no_article;
	}
// *************************************************************************************
// GETTERS
// *************************************************************************************
	public String getRue() {
		return rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public String getVille() {
		return ville;
	}
	public int getNo_article() {
		return no_article;
	}
// *************************************************************************************
// SETTERS
// *************************************************************************************
	public void setRue(String rue) {
		this.rue = rue;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
}
