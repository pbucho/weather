package pt.bucho.weather.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.weather.entities.JSONFile;
import pt.bucho.weather.persistence.DefaultHibernateConfigurationFactory;
import pt.bucho.weather.persistence.HibernateDAO;

public class JSONFileSaverServiceTest {

	private HibernateDAO dao;
	private JSONFileSaverService saverService;
	
	private File lisboaFile;
	private File example1File;
	
	private JSONFile lisboaJSONFile;
	private JSONFile example1JSONFile;
	
	@Before
	public void setUp() {
		dao = new HibernateDAO(new DefaultHibernateConfigurationFactory().getConfiguration().buildSessionFactory());
		saverService = new JSONFileSaverService(dao);
		
		lisboaFile = new File("src/test/resources/lisboa.json");
		example1File = new File("src/test/resources/example1.json");
		
		lisboaJSONFile = new JSONFile(lisboaFile);
		example1JSONFile = new JSONFile(example1File);
	}
	
	@Test
	public void noPreviousFiles() {
		assertNull(dao.getJSONFileByPath(lisboaFile.getAbsolutePath()));
		assertNull(dao.getJSONFileByPath(example1File.getAbsolutePath()));
		
		assertFalse(saverService.save(lisboaJSONFile));
		assertFalse(saverService.save(example1JSONFile));
		
		assertions();
	}
	
	@Test
	public void existingFile() {
		dao.save(lisboaJSONFile);
		
		assertNotNull(dao.getJSONFileByPath(lisboaFile.getAbsolutePath()));
		assertNull(dao.getJSONFileByPath(example1File.getAbsolutePath()));
		
		assertTrue(saverService.save(lisboaJSONFile));
		assertFalse(saverService.save(example1JSONFile));
		
		assertions();
	}
	
	private void assertions() {
		JSONFile actualLisboaFile = dao.getJSONFileByPath(lisboaFile.getAbsolutePath());
		JSONFile actualExample1File = dao.getJSONFileByPath(example1File.getAbsolutePath());
		
		assertNotNull(actualLisboaFile);
		assertNotNull(actualExample1File);
		assertEquals(lisboaFile.getAbsolutePath(), actualLisboaFile.getPath());
		assertEquals(example1File.getAbsolutePath(), actualExample1File.getPath());
	}
	
}
