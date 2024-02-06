package com.rentalcar.web.controller;

import com.rentalcar.web.dto.CarDto;
import com.rentalcar.web.dto.TestdriveDto;
import com.rentalcar.web.models.Testdrive;
import com.rentalcar.web.models.UserEntity;
import com.rentalcar.web.security.SecurityUtil;
import com.rentalcar.web.service.TestdriveService;
import com.rentalcar.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestdriveController {
    private TestdriveService testdriveService;
    private UserService userService;

    @Autowired
    public TestdriveController(TestdriveService testdriveService, UserService userService) {
        this.testdriveService = testdriveService;
        this.userService = userService;
    }

    @GetMapping("/testdrives")
    public String getTestdriveList(Model model) {
        UserEntity user = new UserEntity();
        List<TestdriveDto> testdrives = testdriveService.findAllTestdrives();
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("testdrives", testdrives);
        return "testdrives-list";
    }

    @GetMapping("/testdrives/{testdriveId}")
    public String viewTestdrive(@PathVariable("testdriveId") Long testdriveId, Model model) {
        UserEntity user = new UserEntity();
        TestdriveDto testdriveDto = testdriveService.findByTestdriveId(testdriveId);
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("testdrive", testdriveDto);
        return "testdrives-details";
    }

    @GetMapping("/testdrives/{carId}/new")
    public String createTestdriveForm(@PathVariable("carId") Long carId, Model model) {
        Testdrive testdrive = new Testdrive();
        model.addAttribute("carId", carId);
        model.addAttribute("testdrive", testdrive);
        return "testdrives-create";
    }

    @PostMapping("/testdrives/{carId}")
    public String createTestdrive(@PathVariable("carId") Long carId, @ModelAttribute("testdrive")TestdriveDto testdriveDto,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("testdrive", testdriveDto);
            return "testdrives-create";
        }

        testdriveService.createTestdrive(carId, testdriveDto);
        return "redirect:/cars/" + carId;
    }

    @GetMapping("/testdrives/{testdriveId}/edit")
    public String editTestdriveForm(@PathVariable("testdriveId") Long testdriveId, Model model) {
        TestdriveDto testdriveDto = testdriveService.findByTestdriveId(testdriveId);
        model.addAttribute("testdrive", testdriveDto);
        return "testdrives-edit";
    }

    @PostMapping("/testdrives/{testdriveId}/edit")
    public String updateTestdrive(@PathVariable("testdriveId") Long testdriveId,
                            @Valid @ModelAttribute("testdrive") TestdriveDto testdriveDto,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("testdrive", testdriveDto);
            return "testdrives-edit";
        }

        TestdriveDto editableTestdrive = testdriveService.findByTestdriveId(testdriveId);

        testdriveDto.setId(testdriveId);
        testdriveDto.setCar(editableTestdrive.getCar());
        testdriveService.updateTestdrive(testdriveDto);

        return "redirect:/testdrives";
    }

    @GetMapping("/testdrives/{testdriveId}/delete")
    public String deleteTestdrive(@PathVariable("testdriveId") Long testdriveId) {
        testdriveService.deleteTestdrive(testdriveId);

        return "redirect:/testdrives";
    }
}
