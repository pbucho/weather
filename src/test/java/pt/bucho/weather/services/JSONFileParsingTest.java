package pt.bucho.weather.services;

import org.junit.Test;

import pt.bucho.utilities.geopt.District;
import pt.bucho.weather.AbstractTest;

public class JSONFileParsingTest extends AbstractTest {

	private JSONParsingService parsingService;
	private JSONParserFactory parserFactory;
	
	@Test
	public void happyPath() {
		parserFactory = new LocalJSONFactory("src/test/resources/example1.json");
		expectedReport.setDistrict(District.LISBOA);
		
		parsingService = new JSONParsingServiceImpl(parserFactory);
		parsingService.parse();
		actualReport = parsingService.getReport();
		
		assertions();
	}
	
	@Test
	public void faro() {
		parserFactory = new LocalJSONFactory("src/test/resources/dir/example2.json");
		expectedReport.setDistrict(District.FARO);
		
		parsingService = new JSONParsingServiceImpl(parserFactory);
		parsingService.parse();
		actualReport = parsingService.getReport();
		
		assertions();
	}

}
