package pt.bucho.weather.services;

import java.io.File;
import java.nio.file.NotDirectoryException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.bucho.weather.entities.JSONFile;
import pt.bucho.weather.entities.Report;
import pt.bucho.weather.entities.ReportCollection;
import pt.bucho.weather.persistence.HibernateDAO;

public class DirectoryParsingService implements JSONParsingService {

	private final Logger log;
	
	private HibernateDAO dao;
	private File directory;
	private JSONFileSaverService jsonSaver;
	
	private ReportCollection reports;
	
	public DirectoryParsingService(HibernateDAO dao, File dir) {
		this.dao = dao;
		this.log = LogManager.getRootLogger();
		
		if(!dir.isDirectory())
			throw new IllegalArgumentException("Must specify a directory");
		
		this.directory = dir;
		
		jsonSaver = new JSONFileSaverService(dao);
		reports = new ReportCollection();
	}

	public void parse() {
		try {
			parseDirectory(directory);
		} catch (NotDirectoryException e) {
			e.printStackTrace();
		}
	}
	
	private void parseDirectory(File directory) throws NotDirectoryException {
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
			JSONFile jsonFile = new JSONFile(file);

			JSONParserFactory parserFactory = new LocalJSONFactory(file.getAbsolutePath());
			JSONParsingService parsingService = new JSONParsingServiceImpl(parserFactory);
			
			if(dao.getJSONFileByPath(jsonFile.getPath()) != null){
				log.info("Skipping existing file " + jsonFile.getPath());
				continue;
			}
			parsingService.parse();
			
			Report report = parsingService.getReport();
			dao.saveReport(report);
			reports.addReport(report);
			jsonSaver.save(jsonFile);
			log.info("Finished parsing " + jsonFile.getPath());
		}
	}

	public Report getReport() {
		return reports;
	}
	
	
}
