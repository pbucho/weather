package pt.bucho.weather.frontend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.cfg.Configuration;

import pt.bucho.weather.persistence.DefaultHibernateConfigurationFactory;
import pt.bucho.weather.services.JSONParserFactory;
import pt.bucho.weather.services.JSONParsingService;
import pt.bucho.weather.services.JSONParsingServiceImpl;
import pt.bucho.weather.services.LocalJSONFactory;

/**
 * Receives a list of strings containing the path for the local files to be
 * parsed
 * 
 * @author Pedro Bucho
 *
 */
public class FileListParsing {
	
	protected static final Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		
		for(String filename : args) {
			JSONParserFactory parserFactory = new LocalJSONFactory(filename);
			JSONParsingService parsingService = new JSONParsingServiceImpl(parserFactory);
			parsingService.parse();
			
			log.info("File " + filename + " parsed");
			
			// right now, throws it away
			
			Configuration cfg = new DefaultHibernateConfigurationFactory().getConfiguration();
			cfg.buildSessionFactory();
		}
		
	}

}
