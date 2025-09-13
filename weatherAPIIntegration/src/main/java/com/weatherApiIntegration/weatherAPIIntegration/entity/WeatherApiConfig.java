package com.weatherApiIntegration.weatherAPIIntegration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherApiConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String url;
	private String apiKey;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	@Override
	public String toString() {
		return "WeatherApiConfig [id=" + id + ", url=" + url + ", apiKey=" + apiKey + "]";
	}
	
//	String apiKey = "9906863f029ba778696483ca0e0ade04";
//	String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
	
	
}
