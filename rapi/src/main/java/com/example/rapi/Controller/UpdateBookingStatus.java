package com.example.rapi.Controller;

import com.example.rapi.Controller.Auth.AuthValidation;
import com.example.rapi.Dto.StatusUpdate;
import com.example.rapi.Model.BookingStatus;
import com.example.rapi.Repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateBookingStatus {

    @Autowired
    AuthValidation authValidation;

    @Autowired
    BookingRepo bookingRepo;

    @PutMapping("updateStatus")
    public String updateStatus(@RequestBody StatusUpdate statusUpdate){
        if(authValidation.validateDToken(statusUpdate.getToken(),statusUpdate.getEmail())){
            if(statusUpdate.getStatus().equals(BookingStatus.cancelled) || statusUpdate.getStatus().equals(BookingStatus.ended)){
                bookingRepo.deleteById(statusUpdate.getBookingId());
            }else{
                var booking = bookingRepo.findById(statusUpdate.getBookingId()).orElseThrow();
                booking.setBookingStatus(statusUpdate.getStatus());
                return "Status updated to: "+ statusUpdate.getStatus();
            }
        }
            return "unauthorized access";

    }
}
