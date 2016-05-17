package pt.bucho.weather.frontend;

import java.io.File;
import java.nio.file.NotDirectoryException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.bucho.weather.services.JSONParserFactory;
import pt.bucho.weather.services.JSONParsingService;
import pt.bucho.weather.services.JSONParsingServiceImpl;
import pt.bucho.weather.services.LocalJSONFactory;

/**
 * Receives a string containing the path for a directoy containing files to be
 * parsed. Only JSON files are parsed.
 * 
 * @author Pedro Bucho
 *
 */
public class DirectoryParsing {

	protected static final Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) throws NotDirectoryException {
		
		if(args.length < 1){
			log.error("Directory name not present");
			System.exit(1);
		}
		
		String dirname = args[0];
		
		File directory = new File(dirname);
		if(!directory.isDirectory()){
			throw new NotDirectoryException(dirname + " is not a directory");
		}
		
		File[] containedFiles = directory.listFiles();
		for(File file : containedFiles) {
			String filename = file.getName();
			String[] pieces = filename.split("\\.");
			if(pieces.length < 2){
				continue;
			}
			String extension = pieces[pieces.length - 1];
			if(!extension.equalsIgnoreCase("json")){
				continue;
			}
			
			JSONParserFactory parserFactory = new LocalJSONFactory(dirname + "/" + filename);
			JSONParsingService parsingService = new JSONParsingServiceImpl(parserFactory);
			parsingService.parse();
			
			log.info("File " + filename + " parsed");
			
			// right now, throws it away
		}
	}

}
