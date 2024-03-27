package com.example.rapi.Service;

import com.example.rapi.Controller.Auth.AuthValidation;
import com.example.rapi.Dto.FromToDto;
import com.example.rapi.Model.BookingStatus;
import com.example.rapi.Model.Bookings;
import com.example.rapi.Model.Driver;
import com.example.rapi.Model.User;
import com.example.rapi.Repo.BookingRepo;
import com.example.rapi.Repo.DriverAuthRepo;
import com.example.rapi.Repo.UserAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private UserAuthRepo userAuthRepo;

    @Autowired
    private DriverAuthRepo driverAuthRepo;
    @Autowired
    private AuthValidation authValidation;

    public String bookRide(FromToDto fromToDto) {
        String token = fromToDto.getToken();
        String email= fromToDto.getUserEmail();
        if(authValidation.validToken(token,email)){
            User user = userAuthRepo.findByEmail(email);

            var booking= new Bookings(null,user, BookingStatus.accepted);
            bookingRepo.save(booking);
            return "Booking created successfully";

        }
        return "Unauthenticated access";
    }

    public List<Bookings> getRides(String email, String token) {
        if(authValidation.validToken(email,token)){
            User user= userAuthRepo.findByEmail(email);
          return   bookingRepo.findByUserId(user.getId());
        }
        return null;
    }
}
