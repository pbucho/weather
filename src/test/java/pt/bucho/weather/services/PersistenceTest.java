package pt.bucho.weather.services;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.weather.AbstractTest;
import pt.bucho.weather.persistence.DefaultHibernateConfigurationFactory;
import pt.bucho.weather.persistence.HibernateDAO;

public class PersistenceTest extends AbstractTest {
	
	private HibernateDAO dao;
	
	@Before
	public void setUp() {
		dao = new HibernateDAO(new DefaultHibernateConfigurationFactory().getConfiguration().buildSessionFactory());
	}
	
	@Test
	public void test() {
		dao.saveReport(expectedReport);
		actualReport = dao.getReport(expectedReport.getId());
		
		assertions();
	}

}
