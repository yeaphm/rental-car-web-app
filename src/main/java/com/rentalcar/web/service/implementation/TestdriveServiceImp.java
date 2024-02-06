package com.rentalcar.web.service.implementation;

import com.rentalcar.web.dto.TestdriveDto;
import com.rentalcar.web.models.Testdrive;
import com.rentalcar.web.repository.CarRepository;
import com.rentalcar.web.repository.TestdriveRepository;
import com.rentalcar.web.service.TestdriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentalcar.web.models.Car;

import java.util.List;
import java.util.stream.Collectors;

import static com.rentalcar.web.mapper.TestdriveMapper.mapToTestdrive;
import static com.rentalcar.web.mapper.TestdriveMapper.mapToTestdriveDto;

@Service
public class TestdriveServiceImp implements TestdriveService {
    private TestdriveRepository testdriveRepository;
    private CarRepository carRepository;

    @Autowired
    public TestdriveServiceImp(TestdriveRepository testdriveRepository, CarRepository carRepository) {
        this.testdriveRepository = testdriveRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void createTestdrive(Long carId, TestdriveDto testdriveDto) {
        Car car = carRepository.findById(carId).get();
        Testdrive testdrive = mapToTestdrive(testdriveDto);
        testdrive.setCar(car);
        testdriveRepository.save(testdrive);
    }

    @Override
    public List<TestdriveDto> findAllTestdrives() {
        List<Testdrive> testdrives = testdriveRepository.findAll();
        return testdrives.stream().map(testdrive -> mapToTestdriveDto(testdrive)).collect(Collectors.toList());
    }

    @Override
    public TestdriveDto findByTestdriveId(Long testdriveId) {
        Testdrive testdrive = testdriveRepository.findById(testdriveId).get();
        return mapToTestdriveDto(testdrive);
    }

    @Override
    public void updateTestdrive(TestdriveDto testdriveDto) {
        Testdrive testdrive = mapToTestdrive(testdriveDto);
        testdriveRepository.save(testdrive);
    }

    @Override
    public void deleteTestdrive(Long testdriveId) {
        testdriveRepository.deleteById(testdriveId);
    }
}
