package com.example.rapi.Controller;

import com.example.rapi.Dto.FromToDto;
import com.example.rapi.Model.Driver;
import com.example.rapi.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
 private BookingService bookingService;

    @PostMapping("bookRide")
    public ResponseEntity<String> bookRide(@RequestBody FromToDto fromToDto){
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.bookRide(fromToDto));
    }
}
