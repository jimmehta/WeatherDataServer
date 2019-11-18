package com.jimmehta.weatherDataServer.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class WeatherData {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Date weatherDataTimeStamp;
        private float temperature;
        private float duePoint;
        private int   precipitation;

        //Default constructor
        public WeatherData() {

        }

    // Constructor
    public WeatherData(Date weatherDataTimeStamp, float temperature, float duePoint, int precipitation) {
        this.weatherDataTimeStamp = weatherDataTimeStamp;
        this.temperature = temperature;
        this.duePoint = duePoint;
        this.precipitation = precipitation;
    }

    public Long getId() {
        return id;
    }

    public Date getWeatherDataTimeStamp() {
        return weatherDataTimeStamp;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getDuePoint() {
        return duePoint;
    }

    public int getPrecipitation() {
        return precipitation;
    }
}
