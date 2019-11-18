package com.jimmehta.weatherDataServer.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class WeatherData {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Timestamp weatherDataTimeStamp;
        private float temperature;
        private float duePoint;
        private float precipitation;

        //Default constructor
        public WeatherData() {

        }

    // Constructor
    public WeatherData(Timestamp weatherDataTimeStamp, float temperature, float duePoint, float precipitation) {
        this.weatherDataTimeStamp = weatherDataTimeStamp;
        this.temperature = temperature;
        this.duePoint = duePoint;
        this.precipitation = precipitation;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getWeatherDataTimeStamp() {
        return weatherDataTimeStamp;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getDuePoint() {
        return duePoint;
    }

    public float getPrecipitation() {
        return precipitation;
    }
}
