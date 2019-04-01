package fr.eni.encheres.bo;

import java.util.Date;

public class Enchere {
	private Date dateEnchere;
	private float montant_enchere;
	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 */
	public Enchere(Date dateEnchere, float montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public float getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(float montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
}
