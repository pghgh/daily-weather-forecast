package com.example.daily_weather_forecast_backend.weather.service;

import com.example.daily_weather_forecast_backend.weather.dto.LocationDto;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/*
TAKEN FROM 1

The code for creating a REST client was taken from https://www.baeldung.com/spring-boot-restclient

TAKEN FROM 2

The code for writing a GET request was taken from https://docs.spring.io/spring-framework/reference/integration/rest-clients.html

TAKEN FROM 3

The code for obtaining the contents of a JSON object was taken from https://www.baeldung.com/jackson-json-to-jsonnode
 */

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    // TAKEN FROM START 1
    private final RestClient restClient = RestClient.create();
    // TAKEN FROM END 1

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
}
