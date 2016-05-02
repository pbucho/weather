package pt.bucho.weather.services;

import java.io.File;
import java.io.FileNotFoundException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class FileLocatingService {
	
	private File intendedFile;
	private DateTimeFormatter dtFormatter = ISODateTimeFormat.basicDateTimeNoMillis();
	
	public FileLocatingService(DateTime currentTime) throws FileNotFoundException {
		String intendedFileName = dtFormatter.print(currentTime.minusMinutes(5)).substring(0, 13) + ".html";
		
		intendedFile = new File(intendedFileName);
		if(!intendedFile.exists()){
			throw new FileNotFoundException("File " + intendedFileName + " does not exist");
		}
	}
	
	public File getFile() {
		return intendedFile;
	}

}
