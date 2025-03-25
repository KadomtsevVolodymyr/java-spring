package com.yievsieievAndrii.rating.repositories;


import org.springframework.data.repository.CrudRepository;

import com.yievsieievAndrii.rating.models.Rate;

/**
 * RatingRepository
 */
public interface RatingRepository extends CrudRepository<Rate, Long> {

}
