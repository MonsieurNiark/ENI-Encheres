package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;


public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Utilisateur utilisateur) throws BusinessException;
	public List<Utilisateur> selectAll() throws BusinessException;
	public Utilisateur selectById(int id) throws BusinessException;
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException;
	public int countByPseudo (String pseudo) throws BusinessException;
	public int countByEmail(String email) throws BusinessException;
	public void updateCredit(Utilisateur utilisateur) throws BusinessException;
}
