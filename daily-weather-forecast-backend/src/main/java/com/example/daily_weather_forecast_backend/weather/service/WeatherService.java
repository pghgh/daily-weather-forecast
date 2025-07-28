package com.example.daily_weather_forecast_backend.weather.service;

import com.example.daily_weather_forecast_backend.weather.dto.LocationDto;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

    LocationDto getLatAndLonOfLocation(LocationDto locationAndTimestampDt);

}
