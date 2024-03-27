package com.example.rapi.Dto;

import com.example.rapi.Model.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusUpdate {
    BookingStatus status;
    Integer bookingId;
    String email;
    String token;
}
