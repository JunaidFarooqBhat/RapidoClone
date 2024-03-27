package com.example.rapi.Controller.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RateList {
    private Double bikeFareInINR;
    private Double cabFareInINR;
    private Double autoFareInINR;
}
