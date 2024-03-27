package com.example.rapi.Dto;

import com.example.rapi.Controller.Location.LatLngLocation;
import com.example.rapi.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FromToDto {
    private LatLngLocation from;
    private LatLngLocation To;
    private String userEmail;
    private String token;
}
