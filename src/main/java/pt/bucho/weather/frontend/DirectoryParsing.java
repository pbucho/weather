package pt.bucho.weather.frontend;

import java.io.File;
import java.nio.file.NotDirectoryException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.cfg.Configuration;

import pt.bucho.weather.persistence.DefaultHibernateConfigurationFactory;
import pt.bucho.weather.persistence.HibernateDAO;
import pt.bucho.weather.services.DirectoryParsingService;

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

	private static DirectoryParsingService parsingService;

	public static void main(String[] args) throws NotDirectoryException {

		if (args.length < 1) {
			log.error("Directory name not present");
			System.exit(1);
		}

		cfg = new DefaultHibernateConfigurationFactory().getConfiguration();
		dao = new HibernateDAO(cfg.buildSessionFactory());

		parsingService = new DirectoryParsingService(dao, new File(args[0]));

		log.info("Starting parsing service");
		parsingService.parse();
		log.info("Finished parsing serivce");

		System.exit(0);
	}

}
