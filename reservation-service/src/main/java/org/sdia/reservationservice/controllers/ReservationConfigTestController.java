package org.sdia.reservationservice.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReservationConfigTestController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @Value("${reservation.params.x}")
    private String x;
    @Value("${reservation.params.y}")
    private String y;
    @GetMapping("/params")
    public Map<String, String> params(){
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    }
}


