package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;


public interface ArticleVenduDAO {
	public void insert(ArticleVendu articlevendu) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public List<ArticleVendu> selectAll() throws BusinessException;
	public List<ArticleVendu> selectParFiltre(int id, String recherche) throws BusinessException;
	public List<ArticleVendu> selectListByIdArticle(int id) throws BusinessException;
	public List<ArticleVendu> selectListByUser(String pseudo) throws BusinessException;
	public List<ArticleVendu> selectListEtat(String pseudo) throws BusinessException;
	public ArticleVendu selectById(int id) throws BusinessException;
	public ArticleVendu selectByIdArticle(int id) throws BusinessException;
	public ArticleVendu selectByLastNomArticle(String nom) throws BusinessException;
}
