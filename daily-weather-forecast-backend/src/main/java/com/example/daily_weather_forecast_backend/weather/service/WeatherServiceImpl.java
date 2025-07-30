package com.example.daily_weather_forecast_backend.weather.service;

import com.example.daily_weather_forecast_backend.location.dto.LocationDto;
import com.example.daily_weather_forecast_backend.location.entity.Location;
import com.example.daily_weather_forecast_backend.location.repository.LocationRepository;
import com.example.daily_weather_forecast_backend.weather.dto.WeatherDto;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.List;

/*
TAKEN FROM 1

The code for creating a REST client was taken from https://www.baeldung.com/spring-boot-restclient

TAKEN FROM 2

The code for writing a GET request was taken from https://docs.spring.io/spring-framework/reference/integration/rest-clients.html

TAKEN FROM 3

The code for obtaining the contents of a JSON object was taken from https://www.baeldung.com/jackson-json-to-jsonnode

TAKEN FROM 4

The code for obtaining an element from a JSON NodeArray was taken from https://stackoverflow.com/a/62090671
 */

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    // TAKEN FROM START 1
    private final RestClient restClient = RestClient.create();
    // TAKEN FROM END 1
    private final LocationRepository locationRepository;

    @Override
    public LocationDto getLatAndLonOfLocation(LocationDto locationDto) {

        String cityName = locationDto.cityName();
        String urlGeocoding = String.format("https://geocoding-api.open-meteo.com/v1/search?name=%s&count=1&language=en&format=json", cityName);

        // TAKEN FROM START 2
        String getRequestGeocodingResult = restClient.get()
            .uri(urlGeocoding)
            .retrieve()
            .body(String.class);
        // TAKEN FROM END 2

        // TAKEN FROM START 3
        JsonNode geocodingResultJson = null;
        double latitude = 0.;
        double longitude = 0.;
        try {
            ObjectMapper mapper = new ObjectMapper();
            geocodingResultJson = mapper.readTree(getRequestGeocodingResult);
            List<String> latitudeValues = geocodingResultJson.findValuesAsText("latitude");
            latitude = Double.parseDouble(latitudeValues.getFirst());
            List<String> longitudeValues = geocodingResultJson.findValuesAsText("longitude");
            longitude = Double.parseDouble(longitudeValues.getFirst());
        }
        catch (Exception e) {
            System.err.print(e.getMessage());
        }
        // TAKEN FROM END 3
        LocationDto updatedLocationDto = new LocationDto(cityName, latitude, longitude);
        return updatedLocationDto;
    }


    @Override
    public WeatherDto getTemperatureOfLocation(LocationDto locationDto) {

        String cityName = locationDto.cityName();
        Double lat = locationDto.lat();
        String latString = String.valueOf(lat);
        Double lon = locationDto.lon();
        String lonString = String.valueOf(lon);
        String urlForecast = String.format("https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&hourly=temperature_2m", latString, lonString);

        // TAKEN FROM START 2
        String getRequestForecastResult = restClient.get()
            .uri(urlForecast)
            .retrieve()
            .body(String.class);
        // TAKEN FROM END 2

        LocalDateTime timeNow = LocalDateTime.now();
        int hourNow = timeNow.getHour();
        Double temp = 0.;

        // TAKEN FROM START 3
        JsonNode forecastResultJson = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            forecastResultJson = mapper.readTree(getRequestForecastResult);
            List<JsonNode> hoursValues = forecastResultJson.findValues("hourly");
            JsonNode temperatures = hoursValues.getFirst().get("temperature_2m");
            // TAKEN FROM START 4
            String tempString = temperatures.get(hourNow).asText();
            // TAKEN FROM END 4
            temp = Double.parseDouble(tempString);
        }
        catch (Exception e) {
            System.err.print(e.getMessage());
        }
        // TAKEN FROM END 3

        Location location = new Location();
        location.setCityName(cityName);
        location.setLat(lat);
        location.setLon(lon);
        locationRepository.save(location);

        WeatherDto weatherDto = new WeatherDto(location.getId(), lat, lon, cityName, timeNow, temp);
        return weatherDto;
    }
}



