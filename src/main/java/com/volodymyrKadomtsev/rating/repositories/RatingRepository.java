package com.volodymyrKadomtsev.rating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volodymyrKadomtsev.rating.models.Rate;

/**
 * RatingRepository
 */
public interface RatingRepository extends JpaRepository<Rate, Long> {

}
