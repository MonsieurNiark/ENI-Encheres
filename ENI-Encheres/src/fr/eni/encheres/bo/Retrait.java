package fr.eni.encheres.bo;

public class Retrait {
	private int no_article;
	private String rue;
	private String code_postal;
	private String ville;
	/**
	 * @param rue
	 * @param code_postal
	 * @param ville
	 */
	public Retrait(int no_article,String rue, String code_postal, String ville) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.no_article = no_article;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getNo_article() {
		return no_article;
	}
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
	
	
}
