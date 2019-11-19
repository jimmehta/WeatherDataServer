package com.jimmehta.weatherDataServer.repository;

import com.jimmehta.weatherDataServer.model.WeatherData;
import com.jimmehta.weatherDataServer.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
    public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
//        @Query("FROM WeatherData WHERE weatherDataTimeStamp = ?1")
        WeatherData findByWeatherDataTimeStamp(Timestamp weatherDataTimeStamp1);

        List<WeatherData> findAllByTimeStamp(Timestamp weatherDataTimeStamp);

        List<WeatherData> findAllByMetricName(float value);

        @Query("FROM WeatherData WHERE weatherDataTimeStamp > ?1")
        List<WeatherData> findAllByWeatherDataTimeStampAfter(Timestamp fromDateTime);

        @Query("FROM WeatherData WHERE weatherDataTimeStamp < ?1")
        List<WeatherData> findAllByWeatherDataTimeStampBefore(Timestamp toDateTime);
}