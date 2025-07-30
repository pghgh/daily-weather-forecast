package com.example.daily_weather_forecast_backend.weather.service;
import com.example.daily_weather_forecast_backend.weather.dto.LocationDto;
import com.example.daily_weather_forecast_backend.weather.dto.WeatherDto;
import com.example.daily_weather_forecast_backend.weather.entity.Weather;
import com.example.daily_weather_forecast_backend.weather.repository.WeatherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*

TAKEN FROM 1

The code for using Mockito alongside dependency injection for testing purposes was taken from
https://www.geeksforgeeks.org/advance-java/resolve-parameterresolutionexception-in-junit-5/
 */

// TAKEN FROM START 1
@ExtendWith(MockitoExtension.class)
public class WeatherServiceImplTest {

    @Mock
    private WeatherRepository weatherRepository;
    @InjectMocks
    private WeatherService weatherService = new WeatherServiceImpl(weatherRepository);

    // TAKEN FROM END 1
    @Test
    public void locationDto_afterBeingSentToWeatherControllerForGeocoding_IsUpdatedWithLatAndLonInfo() {
        LocationDto locationDtoVienna = new LocationDto("Vienna", 0., 0.);
        double latVienna = 48.20849;
        double lonVienna = 16.37208;
        LocationDto updatedLocationDtoVienna = weatherService.getLatAndLonOfLocation(locationDtoVienna);
        assertEquals(latVienna, updatedLocationDtoVienna.lat());
        assertEquals(lonVienna, updatedLocationDtoVienna.lon());

        LocationDto locationDtoLinz = new LocationDto("Linz", 0., 0.);
        double latLinz = 48.30639;
        double lonLinz = 14.28611;
        LocationDto updatedLocationDtoLinz = weatherService.getLatAndLonOfLocation(locationDtoLinz);
        assertEquals(latLinz, updatedLocationDtoLinz.lat());
        assertEquals(lonLinz, updatedLocationDtoLinz.lon());


        LocationDto locationDtoGraz = new LocationDto("Graz", 0., 0.);
        double latGraz = 47.06667;
        double lonGraz = 15.45;
        LocationDto updatedLocationDto = weatherService.getLatAndLonOfLocation(locationDtoGraz);
        assertEquals(latGraz, updatedLocationDto.lat());
        assertEquals(lonGraz, updatedLocationDto.lon());
    }

}
