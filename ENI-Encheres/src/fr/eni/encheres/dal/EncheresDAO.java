package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Enchere;

public interface EncheresDAO {
	public void insert(Enchere enchere) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public List<Enchere> selectAll() throws BusinessException;
	public Enchere selectByUser(int UserId) throws BusinessException;
	public Enchere selectByArticle(int ArticleId) throws BusinessException;
	public Enchere selectLastEnchereByArticle(int id) throws BusinessException;
	public Enchere selectLastEnchereByArticleAndUser(int idArticle, int idUser) throws BusinessException;
	public List<Enchere> selectLastEnchereForEachUser(int idArticle) throws BusinessException;
	
}
