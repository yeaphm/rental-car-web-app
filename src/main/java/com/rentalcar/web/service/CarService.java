package com.rentalcar.web.service;

import com.rentalcar.web.dto.CarDto;
import com.rentalcar.web.models.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<CarDto> findAllCars();
    Car saveCar(CarDto carDto);

    CarDto findCarById(Long carId);

    void updateCar(CarDto car);

    void deleteCar(Long carId);

    List<CarDto> searchCars(String query);
}
