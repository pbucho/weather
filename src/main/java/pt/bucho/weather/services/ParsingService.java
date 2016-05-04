package pt.bucho.weather.services;

import java.io.File;
import java.io.IOException;

import pt.bucho.weather.entities.WeatherForecast;
import pt.bucho.weather.exceptions.UnknownWeatherStateException;
import pt.bucho.weather.state.WeatherStateMapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pt.bucho.weather.state.WeatherState;

public class ParsingService {

	private String path;
	private Document doc;
	
	private int minTemp, maxTemp;
	private WeatherState weatherState;
	
	private WeatherForecast forecast;
	
	public ParsingService(String file) throws IOException{
		this.path = file;
		parse();
	}
	
	private void parse() throws IOException {
		File htmlFile = new File(path);
		doc = Jsoup.parse(htmlFile, "UTF-8", "");
		
		String maxTempStr = doc.getElementsByClass("temp_max").first().html().substring(0, 2);
		String minTempStr = doc.getElementsByClass("temp_min").first().html().substring(0, 2);
		
		try {
			maxTemp = Integer.parseInt(maxTempStr);
		}catch(NumberFormatException e){
			maxTempStr = maxTempStr.substring(0, 1);
			maxTemp = Integer.parseInt(maxTempStr);
		}
		
		try {
			minTemp = Integer.parseInt(minTempStr);
		}catch(NumberFormatException e){
			minTempStr = minTempStr.substring(0, 1);
			minTemp = Integer.parseInt(minTempStr);
		}
		
		Elements imgElements = doc.getElementsByTag("img");
		Element theStateElement = null;
		
		for(Element img : imgElements){
			if(img.attr("src").startsWith("/opencms/bin/images.site/otempo")){
				theStateElement = img;
				break;
			}
		}
		
		if(theStateElement != null){
			try {
				weatherState = WeatherStateMapping.getInstance().getState(theStateElement.attr("title"));
			} catch (UnknownWeatherStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		forecast = new WeatherForecast(null);
		forecast.setMaximumTemperature(maxTemp);
		forecast.setMinumumTemperature(minTemp);
		forecast.setWeatherState(weatherState);
	}
	
	public int getMaxTemperature() {
		return maxTemp;
	}
	
	public int getMinTemperature() {
		return minTemp;
	}
	
	public WeatherState getWeatherState() {
		return weatherState;
	}
	
	public WeatherForecast getForecast() {
		return forecast;
	}
	
}
