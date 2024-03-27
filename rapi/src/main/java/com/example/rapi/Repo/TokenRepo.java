package com.example.rapi.Repo;

import com.example.rapi.Model.TokenUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<TokenUser,Integer> {
    TokenUser findByToken(String token);

    void deleteByToken(String token);
}
