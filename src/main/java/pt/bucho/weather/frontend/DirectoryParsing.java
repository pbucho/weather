package pt.bucho.weather.frontend;

import java.io.File;
import java.nio.file.NotDirectoryException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.cfg.Configuration;

import pt.bucho.weather.persistence.DefaultHibernateConfigurationFactory;
import pt.bucho.weather.persistence.HibernateDAO;
import pt.bucho.weather.services.JSONParserFactory;
import pt.bucho.weather.services.JSONParsingService;
import pt.bucho.weather.services.JSONParsingServiceImpl;
import pt.bucho.weather.services.LocalJSONFactory;

/**
 * Receives a string containing the path for a directoy containing files to be
 * parsed. Only JSON files are parsed. Directory parsing is recursive.
 * 
 * @author Pedro Bucho
 *
 */
public class DirectoryParsing {

	protected static final Logger log = LogManager.getRootLogger();
	protected static Configuration cfg;
	protected static HibernateDAO dao;

	public static void main(String[] args) throws NotDirectoryException {

		if (args.length < 1) {
			log.error("Directory name not present");
			System.exit(1);
		}
		
		cfg = new DefaultHibernateConfigurationFactory().getConfiguration();
		dao = new HibernateDAO(cfg.buildSessionFactory());

		parseDirectory(new File(args[0]));
	}

	private static void parseDirectory(File directory) throws NotDirectoryException {
		String dirname = directory.getName();
		if (!directory.isDirectory()) {
			throw new NotDirectoryException(dirname + " is not a directory");
		}

		File[] containedFiles = directory.listFiles();
		for (File file : containedFiles) {
			if (file.isDirectory()) {
				parseDirectory(file);
				continue;
			}

			String filename = file.getName();
			String[] pieces = filename.split("\\.");
			if (pieces.length < 2) {
				continue;
			}
			String extension = pieces[pieces.length - 1];
			if (!extension.equalsIgnoreCase("json")) {
				continue;
			}

			JSONParserFactory parserFactory = new LocalJSONFactory(file.getAbsolutePath());
			JSONParsingService parsingService = new JSONParsingServiceImpl(parserFactory);
			parsingService.parse();
			dao.saveReport(parsingService.getReport());
			log.info("File " + file.getAbsolutePath() + " parsed");
		}
		System.exit(0);
	}

}
