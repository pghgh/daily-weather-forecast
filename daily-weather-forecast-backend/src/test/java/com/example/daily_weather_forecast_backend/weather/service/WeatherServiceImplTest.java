package com.example.daily_weather_forecast_backend.weather.service;
import com.example.daily_weather_forecast_backend.location.dto.LocationDto;
import com.example.daily_weather_forecast_backend.location.repository.LocationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

TAKEN FROM 1

The code for using Mockito alongside dependency injection for testing purposes was taken from
https://www.geeksforgeeks.org/advance-java/resolve-parameterresolutionexception-in-junit-5/
 */

// TAKEN FROM START 1
@ExtendWith(MockitoExtension.class)
public class WeatherServiceImplTest {

    @Mock
    private LocationRepository locationRepository;
    @InjectMocks
    private WeatherService weatherService = new WeatherServiceImpl(locationRepository);

    // TAKEN FROM END 1
    @Test
    public void weatherService_afterCallingGetLatAndLonOfLocation_UpdatesLatAndLonInfoOfCity() {
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
