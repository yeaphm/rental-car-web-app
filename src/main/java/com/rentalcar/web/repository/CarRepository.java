package com.rentalcar.web.repository;

import com.rentalcar.web.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByModel(String url);
    @Query("SELECT c from Car c WHERE LOWER(c.model) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Car> searchCars(String query);
}
