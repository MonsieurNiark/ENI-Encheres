package fr.eni.encheres.bo;

public class Utilisateur {
// *************************************************************************************
// CHAMPS
// *************************************************************************************
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private int administrateur;
	/**
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
// *************************************************************************************
// CONSTRUCTEURS
// *************************************************************************************
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, int administrateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, int administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}
// *************************************************************************************
// GETTERS
// *************************************************************************************
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getRue() {
		return rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public String getVille() {
		return ville;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public int getCredit() {
		return credit;
	}
	public int getAdministrateur() {
		return administrateur;
	}
// *************************************************************************************
// SETTERS
// *************************************************************************************	
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}	
	public void setEmail(String email) {
		this.email = email;
	}	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}	
	public void setRue(String rue) {
		this.rue = rue;
	}	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public void setAdministrateur(int administrateur) {
		this.administrateur = administrateur;
	}	
}
