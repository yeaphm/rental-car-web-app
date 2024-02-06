package com.rentalcar.web.service.implementation;

import com.rentalcar.web.dto.CarDto;
import com.rentalcar.web.models.Car;
import com.rentalcar.web.models.UserEntity;
import com.rentalcar.web.repository.CarRepository;
import com.rentalcar.web.repository.UserRepository;
import com.rentalcar.web.security.SecurityUtil;
import com.rentalcar.web.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rentalcar.web.mapper.CarMapper.mapToCar;
import static com.rentalcar.web.mapper.CarMapper.mapToCarDto;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private UserRepository userRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CarDto> findAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map((car) -> mapToCarDto(car)).collect(Collectors.toList());
    }

    @Override
    public Car saveCar(CarDto carDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Car car = mapToCar(carDto);
        car.setCreatedBy(user);
        return carRepository.save(car);
    }

    @Override
    public CarDto findCarById(Long carId) {
        Car car = carRepository.findById(carId).get();
        return mapToCarDto(car);
    }

    @Override
    public void updateCar(CarDto carDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Car car = mapToCar(carDto);
        car.setCreatedBy(user);
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public List<CarDto> searchCars(String query) {
        List<Car> cars = carRepository.searchCars(query);
        return cars.stream().map(car -> mapToCarDto(car)).collect(Collectors.toList());
    }
}
