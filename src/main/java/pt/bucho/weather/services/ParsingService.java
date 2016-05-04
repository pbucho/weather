package pt.bucho.weather.services;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import pt.bucho.utilities.geopt.District;
import pt.bucho.weather.entities.WeatherForecast;
import pt.bucho.weather.exceptions.UnknownWeatherStateException;
import pt.bucho.weather.state.WeatherStateMapping;

import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pt.bucho.weather.state.WeatherState;

public class ParsingService {

	private String path;
	private Document doc;
	
	private WeatherForecast forecast;
	
	public ParsingService(String file) throws IOException{
		this.path = file;
		parse();
	}
	
	private void parse() throws IOException {
		File htmlFile = new File(path);
		doc = Jsoup.parse(htmlFile, "UTF-8", "");
		forecast = new WeatherForecast(DateTime.now());
		
		Element tabMeteo = doc.getElementById("tab_meteo");
		
		Element tableLocation = tabMeteo.getElementById("tit_cidade");
		forecast.setForecastDistrict(District.valueOf(tableLocation.getElementsByClass("tit_cidade").get(0).html().trim().toUpperCase()));
		
		Element tableImage = tabMeteo.getElementsByTag("tr").get(3).getElementsByTag("td").get(1).getElementsByTag("img").get(0);
		forecast.setWeatherState(WeatherState.valueOf(tableImage.attr("title").toUpperCase(Locale.ENGLISH)));
		
		
	}
	
	public WeatherForecast getForecast() {
		return forecast;
	}
	
}
