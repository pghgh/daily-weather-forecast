package com.example.daily_weather_forecast_backend.app;

import com.example.daily_weather_forecast_backend.location.dto.LocationDto;
import com.example.daily_weather_forecast_backend.weather.dto.WeatherDto;
import com.example.daily_weather_forecast_backend.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/daily-weather-forecast")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/location")
    public LocationDto getLatAndLonOfLocation(LocationDto locationDto) {
        if (locationDto == null || locationDto.cityName() == null || locationDto.cityName().isEmpty())
            locationDto = new LocationDto("Vienna", 0., 0.);
        return weatherService.getLatAndLonOfLocation(locationDto);
    }

    @GetMapping("/temperature")
    public WeatherDto getTemperatureOfLocation(LocationDto locationDto) {
        if (locationDto == null || locationDto.cityName() == null || locationDto.cityName().isEmpty())
            locationDto = new LocationDto("Vienna", 48.20849, 16.37208);
        return weatherService.getTemperatureOfLocation(locationDto);
    }

}
