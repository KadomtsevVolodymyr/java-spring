package com.volodymyrKadomtsev.rating;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RatingRepository
 */
public interface RatingRepository extends JpaRepository<Rate, Long> {

}
