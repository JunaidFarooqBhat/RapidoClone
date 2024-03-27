package com.example.rapi.Dto;

import com.example.rapi.Model.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CancelDetails {
    String token;
    String email;
    BookingStatus status;
    Integer BookingId;
}
