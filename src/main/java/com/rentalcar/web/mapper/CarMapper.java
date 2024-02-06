package com.rentalcar.web.mapper;

import com.rentalcar.web.dto.CarDto;
import com.rentalcar.web.models.Car;

import java.util.stream.Collectors;

import static com.rentalcar.web.mapper.TestdriveMapper.mapToTestdriveDto;

public class CarMapper {
    public static Car mapToCar(CarDto car) {
        Car carDto = Car.builder()
                .id(car.getId())
                .model(car.getModel())
                .photoUrl(car.getPhotoUrl())
                .description(car.getDescription())
                .createdBy(car.getCreatedBy())
                .createdOn(car.getCreatedOn())
                .updatedOn(car.getUpdatedOn())
                .build();

        return carDto;
    }

    public static CarDto mapToCarDto (Car car) {
        CarDto carDto = CarDto.builder()
                .id(car.getId())
                .model(car.getModel())
                .photoUrl(car.getPhotoUrl())
                .description(car.getDescription())
                .createdBy(car.getCreatedBy())
                .createdOn(car.getCreatedOn())
                .updatedOn(car.getUpdatedOn())
                .testdrives(car.getTestdrives().stream().map((testdrive) -> mapToTestdriveDto(testdrive)).collect(Collectors.toList()))
                .build();

        return carDto;
    }
}
