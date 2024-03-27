package com.example.rapi.Controller;

import com.example.rapi.Controller.Location.RateList;
import com.example.rapi.Dto.FromToDto;
import com.example.rapi.Service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FareController {

    @Autowired
    private FareService fareService;

    @GetMapping("checkFare")
    public ResponseEntity<RateList> checkFare(@RequestBody FromToDto fromToDto){

         return ResponseEntity.status(HttpStatus.OK).body(fareService.checkFare(fromToDto));
    }
}
