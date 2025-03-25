package com.yievsieievAndrii.carsharing.repositories;

import java.util.List;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yievsieievAndrii.carsharing.models.Car;

/**
 * CarsharingRepository
 */
public interface CarRepository extends CouchbaseRepository<Car, String> {
  @Query("SELECT c.* FROM `carsharingdb` c " +
       "LEFT JOIN `carsharingdb` cs ON META(c).id = cs.carId " +
       "WHERE cs.isExpired = FALSE OR cs IS MISSING")
List<Car> findAllWithBookingStatus();

  List<Car> findByMark(String mark);
}
