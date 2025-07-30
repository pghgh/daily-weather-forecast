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

/*
TAKEN FROM 1

The settings for specifying the database schema were taken from https://stackoverflow.com/questions/39430422/how-to-properly-specify-database-schema-in-spring-boot
 */

import java.time.LocalDateTime;

@Entity
// TAKEN FROM START 1
@Table(name = "weather", schema = "public")
// TAKEN FROM END 1
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

    @Column(name = "timestamp")
    @CreationTimestamp
    private LocalDateTime timestamp;

    @Column(name = "temperature")
    private Double temperature;


}
