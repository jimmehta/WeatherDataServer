package com.jimmehta.weatherDataServer.service;

import com.jimmehta.weatherDataServer.model.WeatherData;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface WeatherDataService {
    List<WeatherData> getAllWeatherData();
    WeatherData getSingleWeatherData(Timestamp weatherDataTimeStamp);
    ResponseEntity<WeatherData> createWeatherData(WeatherData weatherData);
    List<WeatherData> getAllWeatherDataForDuePoint(float duePoint);
    List<WeatherData> getAllWeatherDataForPrecipitation(int precipitation);
    List<WeatherData> getAllWeatherDataFromDateTime(Timestamp fromDateTime);
    List<WeatherData> getAllWeatherDataToDateTime(Timestamp toDateTime);
}
