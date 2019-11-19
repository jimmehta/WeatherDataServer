package com.jimmehta.weatherDataServer.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Timestamp weatherDataTimeStamp;
    private String     MetricName;
    private float      value;

        //Default constructor
        public WeatherData() {

        }

    public WeatherData(Long id, Timestamp weatherDataTimeStamp, String metricName, float value) {
        Id = id;
        this.weatherDataTimeStamp = weatherDataTimeStamp;
        MetricName = metricName;
        this.value = value;
    }

    public Long getId() {
        return Id;
    }

    public Timestamp getWeatherDataTimeStamp() {
        return weatherDataTimeStamp;
    }

    public String getMetricName() {
        return MetricName;
    }

    public float getValue() {
        return value;
    }
}
