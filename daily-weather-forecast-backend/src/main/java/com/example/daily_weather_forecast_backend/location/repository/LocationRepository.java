package com.example.daily_weather_forecast_backend.location.repository;

import com.example.daily_weather_forecast_backend.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
