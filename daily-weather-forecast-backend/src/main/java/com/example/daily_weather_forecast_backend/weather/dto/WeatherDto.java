package com.example.daily_weather_forecast_backend.weather.dto;

import java.time.LocalDateTime;

public record WeatherDto(Long id, Double lat, Double lon, String cityName, String countryCode,
                         String timezone, LocalDateTime timestamp, Double temperature) {
}