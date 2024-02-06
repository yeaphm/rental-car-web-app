package com.rentalcar.web.controller;

import com.rentalcar.web.dto.CarDto;
import com.rentalcar.web.models.Car;
import com.rentalcar.web.models.UserEntity;
import com.rentalcar.web.security.SecurityUtil;
import com.rentalcar.web.service.CarService;
import com.rentalcar.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {
    private CarService carService;

    private UserService userService;

    @Autowired
    public CarController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping("/cars")
    public String listCars(Model model) {
        UserEntity user = new UserEntity();
        List<CarDto> cars = carService.findAllCars();
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("cars", cars);
        return "cars-list";
    }

    @GetMapping("/cars/new")
    public String addCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "cars-add";
    }

    @PostMapping("/cars/new")
    public String saveCar(@Valid @ModelAttribute("car") CarDto carDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("car", carDto);
            return "cars-add";
        }

        carService.saveCar(carDto);
        return "redirect:/cars";
    }

    @GetMapping("/cars/{carId}/edit")
    public String editCarForm(@PathVariable("carId") Long carId, Model model) {
        CarDto car = carService.findCarById(carId);
        model.addAttribute("car", car);
        return "cars-edit";
    }

    @PostMapping("/cars/{carId}/edit")
    public String updateCar(@PathVariable("carId") Long carId,
                            @Valid @ModelAttribute("car") CarDto carDto,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("car", carDto);
            return "cars-edit";
        }

        carDto.setId(carId);
        carService.updateCar(carDto);
        return "redirect:/cars";
    }

    @GetMapping("/cars/{carId}")
    public String carDetails(@PathVariable("carId") Long carId, Model model) {
        UserEntity user = new UserEntity();
        CarDto carDto = carService.findCarById(carId);
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("car", carDto);
        return "cars-details";
    }

    @GetMapping("/cars/{carId}/delete")
    public String deleteCar(@PathVariable("carId") Long carId) {
        carService.deleteCar(carId);
        return "redirect:/cars";
    }

    @GetMapping("/cars/search")
    public String searchCar(@RequestParam(value = "query") String query, Model model) {
        List<CarDto> cars = carService.searchCars(query);
        model.addAttribute("cars", cars);

        return "cars-list";
    }
}
