package com.yievsieievAndrii.carsharing.repositories;

import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yievsieievAndrii.carsharing.models.Carsharing;


/**
 * CarsharingRepository
 */
public interface CarsharingRepository extends CrudRepository<Carsharing, String> {

    @Query("#{#n1ql.delete} WHERE car.id = $1 AND user.id = $2")
    void unbookCar(String carId, Long userId);

    void deleteByCarIdAndUserId(String carId, Long userId);

    @Query("#{#n1ql.delete} WHERE car.id = $1")
    void deleteByCarId(String carId);

}
