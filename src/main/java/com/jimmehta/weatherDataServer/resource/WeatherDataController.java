package com.jimmehta.weatherDataServer.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jimmehta.weatherDataServer.model.WeatherData;
import com.jimmehta.weatherDataServer.service.WeatherDataService;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/measurements")
public class WeatherDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataController.class);

    private final WeatherDataService weatherDataService;

    @Autowired
    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @GetMapping
    public ResponseEntity getAllWeatherData() {
        LOGGER.info("******* getting all the measurements *******");
        return ResponseEntity.ok(weatherDataService.getAllWeatherData());
    }

    @GetMapping("/{measurementTime}")
    public ResponseEntity getSingleWeatherData(@PathVariable Timestamp measurementTime) {
        LOGGER.info("******* getting Single measurement *******");
        WeatherData weatherData = weatherDataService.getSingleWeatherData(measurementTime);
        if (weatherData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weatherData);
    }

    @PostMapping
    public ResponseEntity<Object> createWeatherData(@RequestBody WeatherData weatherData) {
        LOGGER.info("******* creating Single weatherData *******");
        ResponseEntity weatherDataSaved = weatherDataService.createWeatherData(weatherData);
        return ResponseEntity.ok(weatherDataSaved);
    }

    @GetMapping("/stat/{measurementTime}")
    public ResponseEntity getStatSingleWeatherData(@PathVariable Timestamp measurementTime) {
        LOGGER.info("******* getting Single measurementTime *******");
        WeatherData weatherData = weatherDataService.getSingleWeatherData(measurementTime);
        if (weatherData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weatherData);
    }

    @GetMapping("/stat/duePoint/{duePoint}")
    public ResponseEntity getAllWeatherDataForDuePoint(@PathVariable float duePoint) {
        LOGGER.info("******* getting Single duePoint *******");
        List<WeatherData> weatherData = weatherDataService.getAllWeatherDataForDuePoint(duePoint);
        if (weatherData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weatherData);
    }

    @GetMapping("/stat/precipitation/{precipitation}")
    public ResponseEntity getAllWeatherDataForprecipitation(@PathVariable int precipitation) {
        LOGGER.info("******* getting Single precipitation *******");
        List<WeatherData> weatherData = weatherDataService.getAllWeatherDataForPrecipitation(precipitation);
        if (weatherData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weatherData);
    }

    @GetMapping("/stat/{fromDateTime}")
    public ResponseEntity getAllWeatherDataFromDateTime(@PathVariable Timestamp fromDateTime) {
        LOGGER.info("******* getting Single fromDateTime *******");
        List<WeatherData> weatherData = weatherDataService.getAllWeatherDataFromDateTime(fromDateTime);
        if (weatherData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weatherData);
    }

    @GetMapping("/stat/{toDateTime}")
    public ResponseEntity getAllWeatherDataToDateTime(@PathVariable Timestamp toDateTime) {
        LOGGER.info("******* getting Single toDateTime *******");
        List<WeatherData> weatherData = weatherDataService.getAllWeatherDataToDateTime(toDateTime);
        if (weatherData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weatherData);
    }
}
