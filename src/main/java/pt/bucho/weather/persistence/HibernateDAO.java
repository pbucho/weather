package pt.bucho.weather.persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WeatherData.class);
		WeatherData result = (WeatherData) criteria.add(Restrictions.eq("id", id)).uniqueResult();
		commit();
		return result;
	}
	
	public Report getReport(int id) {
		beginTransaction();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Report.class);
		Report result = (Report) criteria.add(Restrictions.eq("id", id)).uniqueResult();
		commit();
		return result;
	}
	
	public void beginTransaction() {
		sessionFactory.getCurrentSession().beginTransaction();
	}
	
	public void commit() {
		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
}
