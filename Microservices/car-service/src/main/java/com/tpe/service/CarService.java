package com.tpe.service;

import com.tpe.CarDTO;
import com.tpe.controller.request.CarRequest;
import com.tpe.domain.Car;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

    private ModelMapper modelMapper;
    private CarRepository carRepository;


    public void saveCar(CarRequest carRequest) {
        Car car = modelMapper.map(carRequest, Car.class);
        carRepository.save(car);
    }

    public List<CarDTO> getAllCars(){
        List<Car> carList= (List<Car>) carRepository.findAll();
        List<CarDTO> carDTOList= carList.stream().map(this::mapCarToCarDTO).collect(Collectors.toList());
        return carDTOList;
    }

    private CarDTO mapCarToCarDTO(Car car) {
        CarDTO carDTO= modelMapper.map(car, CarDTO.class);
        return carDTO;
    }

    public CarDTO getById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Car Not Found with this id:"+id));
        CarDTO carDTO = mapCarToCarDTO(car);
        return carDTO;
    }

}