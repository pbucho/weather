package pt.bucho.weather.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import pt.bucho.weather.entities.JSONFile;
import pt.bucho.weather.entities.Report;
import pt.bucho.weather.entities.WeatherData;

public class HibernateDAO {

	SessionFactory sessionFactory;
	
	public HibernateDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Object obj) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
	}
	
	public void saveReport(Report report) {
		for(WeatherData hour : report.getHourly()){
			save(hour);
		}
		save(report.getHourly());
		save(report.getDaily());
		save(report.getCurrently());
		save(report);
	}
	
	public WeatherData getWeatherData(int id) {
		beginTransaction();
		WeatherData result = (WeatherData) createCriteria(WeatherData.class).add(Restrictions.eq("id", id)).uniqueResult();
		commit();
		return result;
	}

	public Report getReport(int id) {
		beginTransaction();
		Report result = (Report) createCriteria(Report.class).add(Restrictions.eq("id", id)).uniqueResult();
		commit();
		return result;
	}
	
	public JSONFile getJSONFile(int id) {
		beginTransaction();
		JSONFile result = (JSONFile) createCriteria(JSONFile.class).add(Restrictions.eq("id", id)).uniqueResult();
		commit();
		return result;
	}
	
	public JSONFile getJSONFileByPath(String path) {
		beginTransaction();
		JSONFile result = (JSONFile) createCriteria(JSONFile.class).add(Restrictions.eq("path", path)).uniqueResult();
		commit();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<JSONFile> getJSONFiles() {
		beginTransaction();
		List<JSONFile> result = createCriteria(JSONFile.class).list();
		commit();
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	private Criteria createCriteria(Class clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz);
	}
	
	private void beginTransaction() {
		sessionFactory.getCurrentSession().beginTransaction();
	}
	
	private void commit() {
		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
}
