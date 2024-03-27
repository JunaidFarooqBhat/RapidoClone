package com.example.rapi.Controller;

import com.example.rapi.Dto.CancelDetails;
import com.example.rapi.Repo.BookingRepo;
import com.example.rapi.Service.CancelBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cancelbooking {

    @Autowired
    CancelBookService cancelBookService;


    @DeleteMapping("cancelBooking/user")
    public String cancelBooking(@RequestBody CancelDetails cancelDetails){
        return cancelBookService.cancelBooking(cancelDetails);
    }
}
