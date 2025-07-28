package com.example.daily_weather_forecast_backend.weather.repository;

import com.example.daily_weather_forecast_backend.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
