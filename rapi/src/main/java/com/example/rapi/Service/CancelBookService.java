package com.example.rapi.Service;

import com.example.rapi.Controller.Auth.AuthValidation;
import com.example.rapi.Dto.CancelDetails;
import com.example.rapi.Repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelBookService {
    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    AuthValidation authValidation;
    public String cancelBooking(CancelDetails cancelDetails) {
        if(authValidation.validToken(cancelDetails.getToken(), cancelDetails.getEmail())){
            bookingRepo.deleteById(cancelDetails.getBookingId());
            return "Ride cancelled";
        }
        return "unauthorized access";
    }
}
