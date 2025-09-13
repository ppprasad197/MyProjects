package com.weatherApiIntegration.weatherAPIIntegration.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.weatherApiIntegration.weatherAPIIntegration.entity.WeatherApiLog;
import com.weatherApiIntegration.weatherAPIIntegration.service.WeatheApiService;

@RestController
@RequestMapping("/weather")
public class APIController {

	@Autowired
	WeatheApiService weatheApiService;
	
	private final RestTemplate restTemplate = new RestTemplate();

//	@GetMapping("/")
//	public String home() {
//		return "weather api integration app running";
//	}

	@GetMapping("/cityName")
	public String getCityWeather(@RequestParam String city) {
		return weatheApiService.saveWeatherApiLog(city);
	}
}
