package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public List<Utilisateur> selectionnerUtilisateurs() throws BusinessException{
		return utilisateurDAO.selectAll();
	}
	
	public Utilisateur selectionnerUtilisateur(int idUtilisateur) throws BusinessException {
		return utilisateurDAO.selectById(idUtilisateur);
	}
	
	public Utilisateur selectionnerUtilisateurByPseudo(String pseudo) throws BusinessException {
		return utilisateurDAO.selectByPseudo(pseudo);
	}

	public int countByPseudo(String pseudo) throws BusinessException{
		return utilisateurDAO.countByPseudo(pseudo);
	}
	
	public Utilisateur ajouterUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, int administrateur) throws BusinessException {
		Utilisateur nouvelUtilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
		utilisateurDAO.insert(nouvelUtilisateur);
		return nouvelUtilisateur;
	}
	
	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, int administrateur) throws BusinessException {
		Utilisateur nouvelUtilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
		utilisateurDAO.insert(nouvelUtilisateur);
		return nouvelUtilisateur;
	}
	
	public void supprimerUtilisateur(int idUtilisateur) throws BusinessException{
		utilisateurDAO.delete(idUtilisateur);
	}
	
	public void updateUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, int administrateur) throws BusinessException {
		Utilisateur utilisateurAModifier = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
		utilisateurDAO.update(utilisateurAModifier);
	}
	
}
