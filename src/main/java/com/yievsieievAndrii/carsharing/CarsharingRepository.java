package com.yievsieievAndrii.carsharing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

/**
 * CarsharingRepository
 */
public interface CarsharingRepository extends JpaRepository<Carsharing, Long> {

  @Modifying
  @Transactional
  @Query("DELETE FROM Carsharing cs WHERE cs.car.id = :carId AND cs.user.id = :userId")
  void unbookCar( Long carId, Long userId);

  @Modifying
  @Transactional
  @Query("DELETE FROM Carsharing cs WHERE cs.car.id = :carId")
  void deleteByCarId(Long carId);

}
