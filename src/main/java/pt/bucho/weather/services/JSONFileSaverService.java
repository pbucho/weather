package pt.bucho.weather.services;

import org.hibernate.exception.ConstraintViolationException;

import pt.bucho.weather.entities.JSONFile;
import pt.bucho.weather.persistence.HibernateDAO;

public class JSONFileSaverService {

	private HibernateDAO dao;
	
	public JSONFileSaverService(HibernateDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * Wrapper method for the dao.save() method to avoid throwing
	 * ConstraintViolationException. When executed, this method assures that
	 * that specified file is persisted.
	 * 
	 * @param file
	 *            file to save
	 * @return false if the file was not previously in the database, true if it
	 *         was
	 */
	public boolean save(JSONFile file) {
		boolean existing = false;
		try {
			dao.save(file);
		} catch (ConstraintViolationException e) {
			existing = true;
		}
		return existing;
	}
	
}
