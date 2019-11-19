package com.jimmehta.weatherDataServer.service;

import com.jimmehta.weatherDataServer.model.WeatherData;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;

public interface WeatherDataService {
    List<WeatherData> getAllWeatherData();
    WeatherData getSingleWeatherData(Timestamp weatherDataTimeStamp);
    ResponseEntity<WeatherData> createWeatherData(WeatherData weatherData);


    List<WeatherData> getAllWeatherDataTimeStamp(Timestamp weatherDataTimeStamp);
    List<WeatherData> getAllWeatherDataForMetricName(float value);
    List<WeatherData> getAllWeatherDataFromDateTime(Timestamp fromDateTime);
    List<WeatherData> getAllWeatherDataToDateTime(Timestamp toDateTime);
}
