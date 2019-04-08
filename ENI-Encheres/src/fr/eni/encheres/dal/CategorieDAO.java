package fr.eni.encheres.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;

public interface CategorieDAO {
	public void insert(Categorie categorie) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public Categorie selectById(int id) throws BusinessException;
	public ArrayList<Categorie> selectAll() throws BusinessException;
}
