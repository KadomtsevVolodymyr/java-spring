package com.yievsieievAndrii.rating.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yievsieievAndrii.rating.models.Rate;

/**
 * RatingRepository
 */
public interface RatingRepository extends JpaRepository<Rate, Long> {

}
