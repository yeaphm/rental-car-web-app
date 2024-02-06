package com.rentalcar.web.service;

import com.rentalcar.web.dto.TestdriveDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestdriveService {
    void createTestdrive(Long carId, TestdriveDto testdriveDto);
    List<TestdriveDto> findAllTestdrives();

    TestdriveDto findByTestdriveId(Long testdriveId);

    void updateTestdrive(TestdriveDto testdriveDto);

    void deleteTestdrive(Long testdriveId);
}
