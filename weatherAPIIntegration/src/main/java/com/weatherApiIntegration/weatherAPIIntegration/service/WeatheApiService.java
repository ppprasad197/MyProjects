package com.weatherApiIntegration.weatherAPIIntegration.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.weatherApiIntegration.weatherAPIIntegration.entity.WeatherApiConfig;
import com.weatherApiIntegration.weatherAPIIntegration.entity.WeatherApiLog;
import com.weatherApiIntegration.weatherAPIIntegration.repository.WeatherApiConfigRepository;
import com.weatherApiIntegration.weatherAPIIntegration.repository.WeatherApiRepository;

@Service
public class WeatheApiService {
	
	@Autowired
	WeatherApiRepository weatherApiRepository;
	
	@Autowired
	WeatherApiConfigRepository weatherApiConfigRepository;
	
	RestTemplate restTemplate = new RestTemplate();

	public String saveWeatherApiLog(String city) {
		WeatherApiLog weatherApiLog = new WeatherApiLog();
		
		WeatherApiConfig config = weatherApiConfigRepository.findTopByOrderByIdDesc();

		String baseUrl = config.getUrl();
		String apiKey = config.getApiKey();
		String url = baseUrl + "?q=" + city + "&appid=" + apiKey;
		
		try {
		    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		    WeatherApiLog log = new WeatherApiLog();
		    log.setCityName(city);
		    log.setRequestUrl(url);
		    log.setTimeStamp(LocalDateTime.now());
		    log.setStatusCode(response.getStatusCodeValue());
		    log.setResponseData(response.getBody());
		    log.setErrorMessage(null); // No error
		    log.setSuccess(true);
		    weatherApiRepository.save(log);

		    return response.getBody();

		} catch (HttpStatusCodeException ex) {
		    // This will capture the actual error JSON returned by the API
		    WeatherApiLog log = new WeatherApiLog();
		    log.setCityName(city);
		    log.setRequestUrl(url);
		    log.setTimeStamp(LocalDateTime.now());
		    log.setStatusCode(ex.getRawStatusCode());
		    log.setResponseData(null); // no valid response
		    log.setErrorMessage(ex.getResponseBodyAsString()); // real error message
		    log.setSuccess(false);
		    weatherApiRepository.save(log);

		    return ex.getResponseBodyAsString(); // or throw exception
		}
		
	}
}
