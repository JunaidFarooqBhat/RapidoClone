package com.example.rapi.Controller.Auth;

import com.example.rapi.Repo.DTokenRepo;
import com.example.rapi.Repo.TokenRepo;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthValidation {

    @Autowired
    private TokenRepo repo;

    @Autowired
    private DTokenRepo dTokenRepo;
    public  boolean validToken(String token,String email) {
        var authToken= repo.findByToken(token);
        if(authToken.getUser().getEmail().equals(email)){
            return true;
        }
        return false;
    }


    public boolean validateDToken(String token, String email) {
        var authToken = dTokenRepo.findByToken(token);
        if(authToken.getDriver().getEmail().equals(email)){
            return true;
        }
        return false;
    }
}
