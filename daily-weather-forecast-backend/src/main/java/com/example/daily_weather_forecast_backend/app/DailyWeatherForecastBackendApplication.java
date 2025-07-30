package com.example.daily_weather_forecast_backend.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example")
@ComponentScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example")
public class DailyWeatherForecastBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyWeatherForecastBackendApplication.class, args);
	}

}
