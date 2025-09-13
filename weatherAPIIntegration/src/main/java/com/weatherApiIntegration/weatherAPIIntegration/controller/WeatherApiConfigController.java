package com.weatherApiIntegration.weatherAPIIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weatherApiIntegration.weatherAPIIntegration.entity.WeatherApiConfig;
import com.weatherApiIntegration.weatherAPIIntegration.repository.WeatherApiConfigRepository;

@RestController
@RequestMapping("/weather-config")
public class WeatherApiConfigController {
	@Autowired
	WeatherApiConfigRepository weatherApiConfigRepository;

	@PostMapping("/save")
	public WeatherApiConfig saveWeatherApiConfig(@RequestBody WeatherApiConfig weatherApiConfig) {		
		return weatherApiConfigRepository.save(weatherApiConfig);
	}
}
