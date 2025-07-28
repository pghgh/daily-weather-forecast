package com.example.daily_weather_forecast_backend.weather.service;
import com.example.daily_weather_forecast_backend.weather.dto.LocationDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherServiceImplTest {

    private final WeatherServiceImpl weatherServiceImpl = new WeatherServiceImpl();

    @Test
    public void locationDto_afterBeingSentToWeatherController_IsUpdatedWithLatAndLonInfo() {
        LocationDto locationDtoVienna = new LocationDto("Vienna", 0., 0.);
        double latVienna = 48.20849;
        double lonVienna = 16.37208;
        LocationDto updatedLocationDtoVienna = weatherServiceImpl.getLatAndLonOfLocation(locationDtoVienna);
        assertEquals(latVienna, updatedLocationDtoVienna.lat());
        assertEquals(lonVienna, updatedLocationDtoVienna.lon());

        LocationDto locationDtoLinz = new LocationDto("Linz", 0., 0.);
        double latLinz = 48.30639;
        double lonLinz = 14.28611;
        LocationDto updatedLocationDtoLinz = weatherServiceImpl.getLatAndLonOfLocation(locationDtoLinz);
        assertEquals(latLinz, updatedLocationDtoLinz.lat());
        assertEquals(lonLinz, updatedLocationDtoLinz.lon());


        LocationDto locationDtoGraz = new LocationDto("Graz", 0., 0.);
        double latGraz = 47.06667;
        double lonGraz = 15.45;
        LocationDto updatedLocationDto = weatherServiceImpl.getLatAndLonOfLocation(locationDtoGraz);
        assertEquals(latGraz, updatedLocationDto.lat());
        assertEquals(lonGraz, updatedLocationDto.lon());
    }
}
