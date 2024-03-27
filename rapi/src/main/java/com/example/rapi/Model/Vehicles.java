package com.example.rapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String vehicleColor;
    private VehicleType vehicleType;
    private String vehicleNumber;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver owner;

}
