package com.jimmehta.weatherDataServer.repository;

import com.jimmehta.weatherDataServer.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
    public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
//        @Query("FROM WeatherData WHERE weatherDataTimeStamp = ?1")
        WeatherData findByWeatherDataTimeStamp(Date weatherDataTimeStamp1);

//        @Query("FROM WeatherData WHERE duePoint = ?1")
        List<WeatherData> findAllByDuePoint(float duePoint);

//        @Query("FROM WeatherData WHERE precipitation = ?1")
        List<WeatherData> findAllByPrecipitation(float precipitation);

        @Query("FROM WeatherData WHERE weatherDataTimeStamp > ?1")
        List<WeatherData> findAllByFromDateTime(Date fromDateTime);

        @Query("FROM WeatherData WHERE weatherDataTimeStamp < ?1")
        List<WeatherData> findAllByToDateTime(Date toDateTime);
}
