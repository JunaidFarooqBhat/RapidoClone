package com.example.rapi.Repo;

import com.example.rapi.Model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Bookings,Integer> {
    List<Bookings> findByUserId(Integer id);
}
