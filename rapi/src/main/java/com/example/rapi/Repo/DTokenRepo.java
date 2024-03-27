package com.example.rapi.Repo;

import com.example.rapi.Model.TokenDriver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.Inet4Address;

public interface DTokenRepo extends JpaRepository<TokenDriver, Integer> {
    void deleteByToken(String tokenValue);

    TokenDriver findByToken(String tokenValue);
}
