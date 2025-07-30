package com.example.daily_weather_forecast_backend.weather.dto;

/* TAKEN FROM 1
The idea of using "record" for a DTO was taken from https://rameshfadatare.medium.com/spring-boot-crud-example-with-postgresql-926c87f0129a
 */

import java.time.LocalDateTime;

// TAKEN FROM START 1
public record WeatherDto(Long id, Double lat, Double lon, String cityName, LocalDateTime timestamp, Double temperature) {
}
// TAKEN FROM END 1