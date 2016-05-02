package pt.bucho.weather.services;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileLocationTest {
	
	private FileLocatingService flService;

	private File lastHTMLFile;
	private DateTime currentTime;
	private DateTime fiveMinutesAgo;
	private String fiveMinutesAgoStr;
	private DateTimeFormatter dtFormatter;
	
	private File actualHTMLFile;
	
	@Before
	public void setUp() throws IOException {
		dtFormatter = ISODateTimeFormat.basicDateTimeNoMillis();
		currentTime = DateTime.now();
		fiveMinutesAgo = currentTime.minusMinutes(5);
		
		fiveMinutesAgoStr = dtFormatter.print(fiveMinutesAgo).substring(0, 13);
		
		lastHTMLFile = new File(fiveMinutesAgoStr + ".html");
		lastHTMLFile.createNewFile();
	}
	
	@Test
	public void existingFileTest() throws FileNotFoundException {
		flService = new FileLocatingService(currentTime);
		
		actualHTMLFile = flService.getFile();
		
		assertEquals(lastHTMLFile.getAbsolutePath(), actualHTMLFile.getAbsolutePath());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void nonExistingFileTest() throws FileNotFoundException {
		currentTime = currentTime.minusDays(5);
		
		flService = new FileLocatingService(currentTime);
		
		actualHTMLFile = flService.getFile();
	}
	
	@After
	public void tearUp() {
		lastHTMLFile.delete();
	}

}
