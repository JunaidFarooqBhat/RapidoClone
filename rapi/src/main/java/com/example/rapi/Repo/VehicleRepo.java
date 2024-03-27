package com.example.rapi.Repo;

import com.example.rapi.Model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicles,Integer> {
}
