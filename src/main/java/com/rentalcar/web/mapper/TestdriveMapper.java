package com.rentalcar.web.mapper;

import com.rentalcar.web.dto.TestdriveDto;
import com.rentalcar.web.models.Testdrive;

public class TestdriveMapper {
    public static Testdrive mapToTestdrive(TestdriveDto testdriveDto) {
        return Testdrive.builder()
                .id(testdriveDto.getId())
                .name(testdriveDto.getName())
                .startTime(testdriveDto.getStartTime())
                .endTime(testdriveDto.getEndTime())
                .type(testdriveDto.getType())
                .photoUrl(testdriveDto.getPhotoUrl())
                .createdOn(testdriveDto.getCreatedOn())
                .updatedOn(testdriveDto.getUpdatedOn())
                .car(testdriveDto.getCar())
                .build();
    }

    public static TestdriveDto mapToTestdriveDto(Testdrive testdrive) {
        return TestdriveDto.builder()
                .id(testdrive.getId())
                .name(testdrive.getName())
                .startTime(testdrive.getStartTime())
                .endTime(testdrive.getEndTime())
                .type(testdrive.getType())
                .photoUrl(testdrive.getPhotoUrl())
                .createdOn(testdrive.getCreatedOn())
                .updatedOn(testdrive.getUpdatedOn())
                .car(testdrive.getCar())
                .build();
    }
}
