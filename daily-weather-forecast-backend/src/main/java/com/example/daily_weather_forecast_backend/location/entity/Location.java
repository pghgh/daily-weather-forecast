package com.example.daily_weather_forecast_backend.location.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
TAKEN FROM 1

The settings for specifying the database schema were taken from https://stackoverflow.com/questions/39430422/how-to-properly-specify-database-schema-in-spring-boot
 */

@Entity
// TAKEN FROM START 1
@Table(name = "location", schema = "public")
// TAKEN FROM END 1
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

}
