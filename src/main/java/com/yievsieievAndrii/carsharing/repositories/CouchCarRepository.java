package com.yievsieievAndrii.carsharing.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yievsieievAndrii.carsharing.models.Car;

public interface CouchCarRepository extends CrudRepository<Car, String> {
    List<Car> findByMark(String mark);
    List<Car> findByModel(String model);
}