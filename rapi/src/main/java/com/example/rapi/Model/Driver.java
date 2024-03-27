package com.example.rapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String driverName;
    private String email;
    private String password;
    private String phoneNo;
    private String licenceNo;
    @Enumerated
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicle;

}
