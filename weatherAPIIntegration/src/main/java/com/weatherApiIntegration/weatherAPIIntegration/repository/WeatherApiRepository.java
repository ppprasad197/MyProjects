package com.weatherApiIntegration.weatherAPIIntegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weatherApiIntegration.weatherAPIIntegration.entity.WeatherApiLog;

public interface WeatherApiRepository extends JpaRepository<WeatherApiLog, Long>{

}
