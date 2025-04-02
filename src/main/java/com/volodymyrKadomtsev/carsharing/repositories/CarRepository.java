package com.volodymyrKadomtsev.carsharing.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.volodymyrKadomtsev.carsharing.models.Car;

/**
 * CarsharingRepository
 */
public interface CarRepository extends JpaRepository<Car, Long> {
  @Query("SELECT DISTINCT c FROM Car c LEFT JOIN FETCH c.carsharing cs WHERE cs.isExpired = FALSE OR cs IS NULL")
  List<Car> findAllWithBookingStatus();
}
