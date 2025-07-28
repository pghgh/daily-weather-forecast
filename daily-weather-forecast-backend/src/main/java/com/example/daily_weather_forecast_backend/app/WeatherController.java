package com.example.daily_weather_forecast_backend.app;

import com.example.daily_weather_forecast_backend.weather.dto.LocationDto;
import com.example.daily_weather_forecast_backend.weather.service.WeatherService;
import com.example.daily_weather_forecast_backend.weather.service.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/weather-info")
public class WeatherController {

    private final WeatherService weatherService = new WeatherServiceImpl();

    @GetMapping()
    public LocationDto getLatAndLonOfLocation(LocationDto locationDto) {
        return weatherService.getLatAndLonOfLocation(locationDto);
    }

}
