package com.yievsieievAndrii.carsharing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * CarsharingRepository
 */
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c LEFT JOIN FETCH c.carsharing cs WHERE cs.isExpired = FALSE OR cs IS NULL")
    List<Car> findAllWithBookingStatus();
}
