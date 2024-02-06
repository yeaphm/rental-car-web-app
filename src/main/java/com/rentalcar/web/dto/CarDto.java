package com.rentalcar.web.dto;

import com.rentalcar.web.models.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CarDto {
    private Long id;

    @NotEmpty(message = "Car model cannot be empty")
    private String model;

    @NotEmpty(message = "Photo link cannot be empty")
    private String photoUrl;

    @NotEmpty(message = "Car description cannot be empty")
    private String description;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private List<TestdriveDto> testdrives;

    private UserEntity createdBy;
}
