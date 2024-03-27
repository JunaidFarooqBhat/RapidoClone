package com.example.rapi.Repo;

import com.example.rapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    User findByEmail(String email);



    User findByPhoneNo(String phoneNo);
}
