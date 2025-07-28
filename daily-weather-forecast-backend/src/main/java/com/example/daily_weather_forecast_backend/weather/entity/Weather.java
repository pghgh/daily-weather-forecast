package com.example.daily_weather_forecast_backend.weather.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Weather {
    @Id
    @Column(name = "weather_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "timestamp")
    @CreationTimestamp
    private LocalDateTime timestamp;

    @Column(name = "temperature")
    private Double temperature;


}
