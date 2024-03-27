package com.example.rapi.Repo;

import com.example.rapi.Model.Driver;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverAuthRepo extends JpaRepository<Driver, Integer> {
    Driver findByEmail(String email);

    Driver findByPhoneNo(String phoneNo);


}
