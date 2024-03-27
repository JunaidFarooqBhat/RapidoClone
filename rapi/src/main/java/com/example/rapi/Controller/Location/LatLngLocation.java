package com.example.rapi.Controller.Location;

import com.example.rapi.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LatLngLocation {
    private Double lat;
    private Double lng;

}
