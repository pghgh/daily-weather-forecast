package com.example.daily_weather_forecast_backend.app;

import com.example.daily_weather_forecast_backend.location.dto.LocationDto;
import com.example.daily_weather_forecast_backend.weather.dto.WeatherDto;
import com.example.daily_weather_forecast_backend.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/daily-weather-forecast")
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping("/temperature")
    public WeatherDto getTemperatureOfLocation(@RequestParam String cityName) {
        if (cityName == null || cityName.isEmpty())
            cityName = "Vienna";
        LocationDto locationDto = new LocationDto(cityName, 0., 0.);
        LocationDto updatedLocationDto = weatherService.getLatAndLonOfLocation(locationDto);
        return weatherService.getTemperatureOfLocation(updatedLocationDto);
    }

}
