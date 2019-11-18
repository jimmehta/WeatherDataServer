package com.jimmehta.weatherDataServer.service;

import com.jimmehta.weatherDataServer.model.WeatherData;
import com.jimmehta.weatherDataServer.repository.WeatherDataRepository;
import com.jimmehta.weatherDataServer.resource.WeatherDataController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class WeatherDataServiceImpl implements WeatherDataService{

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataService.class);

    private WeatherDataRepository weatherDataRepository;

    @Autowired
    public WeatherDataServiceImpl(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    public List<WeatherData> getAllWeatherData() {
        List<WeatherData> weatherData = weatherDataRepository.findAll();
        return weatherData;
    }

    public WeatherData getSingleWeatherData(Timestamp weatherDataTimeStamp) {
        return weatherDataRepository.findByWeatherDataTimeStamp(weatherDataTimeStamp);
/*
        return weatherDataRepository.findByWeatherDataTimeStamp(weatherDataTimeStamp)
                .map(weatherData -> ResponseEntity.ok().body(weatherData))
                .orElse(ResponseEntity.notFound().build());
*/
    }

    public ResponseEntity<WeatherData> createWeatherData(WeatherData weatherData) {
        LOGGER.info("******* creating Single weatherData In Service *******");
        WeatherData weatherDataSaved = weatherDataRepository.save(weatherData);
        return ResponseEntity.ok(weatherDataSaved);
    }

    public List<WeatherData> getAllWeatherDataForDuePoint(float duePoint) {
        return weatherDataRepository.findAllByDuePoint(duePoint);
    }

    public List<WeatherData> getAllWeatherDataForPrecipitation(int precipitation) {
    return weatherDataRepository.findAllByPrecipitation(precipitation);
    }

    public List<WeatherData> getAllWeatherDataFromDateTime(Timestamp fromDateTime) {
        return weatherDataRepository.findAllByFromDateTime(fromDateTime);
    }

    public List<WeatherData> getAllWeatherDataToDateTime(Timestamp toDateTime) {
        return weatherDataRepository.findAllByToDateTime(toDateTime);
    }
}