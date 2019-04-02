package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;

public interface EncheresDAO {
	public void insert(Enchere enchere) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public List<Enchere> selectAll() throws BusinessException;
	public Enchere selectByUser(int id) throws BusinessException;
	public Enchere selectByArticle(int id) throws BusinessException;
	
}
