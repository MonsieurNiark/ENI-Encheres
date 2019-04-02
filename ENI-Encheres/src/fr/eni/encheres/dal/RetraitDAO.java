package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Retrait;

public interface RetraitDAO {
	public void insert(Retrait retrait) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Retrait retrait) throws BusinessException;
	public Retrait selectById(int id) throws BusinessException;

}
