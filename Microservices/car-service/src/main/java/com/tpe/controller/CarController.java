package com.tpe.controller;

import com.tpe.CarDTO;
import com.tpe.controller.request.CarRequest;
import com.tpe.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    // http://localhost:8085/car/
    /*
    {
    "brand": "audi",
    "age": 7,
    "doors":4,
    "model": "a7",
    "pricePerHour":10.3
}
     */
    @PostMapping
    public ResponseEntity<Map<String,String>> saveCar(@RequestBody CarRequest carRequest) {
        carService.saveCar(carRequest);
        Map<String,String> map = new HashMap<>();
        map.put("message","Car Successfully saved");
        map.put("success","ture");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    // http://localhost:8085/car

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }

    @GetMapping("/id")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long id) {
        CarDTO carDTO = carService.getById(id);
        return ResponseEntity.ok(carDTO);
    }


}
