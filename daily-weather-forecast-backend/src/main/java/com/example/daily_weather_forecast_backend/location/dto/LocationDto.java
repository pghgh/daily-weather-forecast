package com.example.daily_weather_forecast_backend.location.dto;

/* TAKEN FROM 1
The idea of using "record" for a DTO was taken from https://rameshfadatare.medium.com/spring-boot-crud-example-with-postgresql-926c87f0129a
 */

// TAKEN FROM START 1
public record LocationDto(String cityName, Double lat, Double lon) {
}
// TAKEN FROM END 1