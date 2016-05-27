package pt.bucho.weather.services;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.weather.persistence.DefaultHibernateConfigurationFactory;
import pt.bucho.weather.persistence.HibernateDAO;

public class DirectoryParsingServiceTest {

	private HibernateDAO dao;
	private File directory;
	private DirectoryParsingService parsingService;
	
	@Before
	public void setUp() {
		dao = new HibernateDAO(new DefaultHibernateConfigurationFactory().getConfiguration().buildSessionFactory());
		directory = new File("src/test/resources");
		
		parsingService = new DirectoryParsingService(dao, directory);
		
	}
	
	@Test
	public void happyPath() {
		parsingService.parse();
		
		assertEquals(4, dao.getJSONFiles().size());
	}
	
	@Test
	public void dualParsing() {
		happyPath();
		happyPath();
		assertEquals(4, dao.getJSONFiles().size());
	}
		
}
