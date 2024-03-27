package com.example.rapi.Controller;

import com.example.rapi.Model.Bookings;
import com.example.rapi.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetRideDetailsCon {

    @Autowired
    BookingService bookingService;
    @GetMapping("myrides")
    public List<Bookings> getRides(@RequestParam String email, @RequestParam String token){
        return bookingService.getRides(email,token);
    }
}
