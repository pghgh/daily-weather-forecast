package com.example.daily_weather_forecast_backend.weather.service;

import com.example.daily_weather_forecast_backend.location.dto.LocationDto;
import com.example.daily_weather_forecast_backend.weather.dto.WeatherDto;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

    LocationDto getLatAndLonOfLocation(LocationDto locationDto);
    WeatherDto getTemperatureOfLocation(LocationDto locationDto);
}
