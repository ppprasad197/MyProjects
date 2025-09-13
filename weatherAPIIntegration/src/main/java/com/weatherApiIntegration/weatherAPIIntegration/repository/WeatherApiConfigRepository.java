package com.weatherApiIntegration.weatherAPIIntegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weatherApiIntegration.weatherAPIIntegration.entity.WeatherApiConfig;

public interface WeatherApiConfigRepository extends JpaRepository<WeatherApiConfig, Long>{
	WeatherApiConfig findTopByOrderByIdDesc();
}
