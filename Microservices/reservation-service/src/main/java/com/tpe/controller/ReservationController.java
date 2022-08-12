package com.tpe.controller;

import com.netflix.discovery.EurekaClient;
import com.tpe.controller.request.ReservationRequest;
import com.tpe.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {

    private ReservationService reservationService;

    @PostMapping("/{carId}")
    public ResponseEntity<Map<String,String>> saveReservation(
            @PathVariable Long carId, @RequestBody ReservationRequest reservationRequest) {



    }


}
