package pt.bucho.weather.services;

import java.io.File;
import java.io.IOException;

import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pt.bucho.utilities.geopt.District;
import pt.bucho.weather.entities.WeatherForecast;
import pt.bucho.weather.exceptions.UnknownWeatherStateException;
import pt.bucho.weather.state.WeatherStateMapping;

public class ParsingService {

	private static WeatherStateMapping weatherStateMapping = WeatherStateMapping.getInstance();

	private String path;
	private Document doc;

	private WeatherForecast forecast;

	public ParsingService(String file) throws IOException, UnknownWeatherStateException {
		this.path = file;
		parse();
	}

	private void parse() throws IOException, UnknownWeatherStateException {
		File htmlFile = new File(path);
		doc = Jsoup.parse(htmlFile, "UTF-8", "");

		Element tabMeteo = doc.getElementById("tab_meteo");
		Element tableLocation = tabMeteo.getElementById("tit_cidade");
		
		Elements tableRows = tabMeteo.getElementsByTag("tr");
		
		forecast = initializeForecastWithDate();
		
		forecast.setForecastDistrict(District.valueOf(tableLocation.getElementsByClass("tit_cidade").get(0).html().trim().toUpperCase()));
		
		Element tableImage = tableRows.get(3).getElementsByTag("td").get(1).getElementsByTag("img").get(0);
		String stateName = tableImage.attr("title").toUpperCase();
		forecast.setWeatherState(weatherStateMapping.getState(stateName));

		Element temperatureCol = tableRows.get(4);

		String maxStr = temperatureCol.getElementsByClass("temp_max").get(0).html();
		maxStr = maxStr.substring(0, maxStr.length() / 2);
		// TODO: log invalid lengths
		
		String minStr = temperatureCol.getElementsByClass("temp_min").get(0).html();
		minStr = minStr.substring(0, minStr.length() / 2);
		// TODO: log invalid lengths
		
		forecast.setMaximumTemperature(Integer.parseInt(maxStr));
		forecast.setMinumumTemperature(Integer.parseInt(minStr));
	}
	
	private WeatherForecast initializeForecastWithDate() {
		Element infoTable = doc.getElementsByClass("tab_meteo_2").get(0);
		Element innerTd = infoTable.getElementsByTag("tr").get(0).getElementsByTag("td").get(1);
		Element innerItalic = innerTd.getElementsByTag("i").get(0);
		
		String forecastDateTimeStr = innerItalic.html().trim().split(" ")[0];
		
		DateTime forecastDate = new DateTime(forecastDateTimeStr);
		
		return new WeatherForecast(forecastDate);
	}

	public WeatherForecast getForecast() {
		return forecast;
	}

}
