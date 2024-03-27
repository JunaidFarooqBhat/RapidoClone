package com.example.rapi.Service.AuthService;

import com.example.rapi.Model.TokenUser;
import com.example.rapi.Model.User;
import com.example.rapi.Repo.TokenRepo;
import com.example.rapi.Repo.UserAuthRepo;
import com.example.rapi.Service.PassEnc.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserAuthService {

    @Autowired
    private UserAuthRepo userAuthRepo;

    @Autowired
    private TokenRepo tokenRepo;

    public String userSignUp(User newUser) {
        User user= userAuthRepo.findByEmail(newUser.getEmail());
        if(user!=null){
            return "user already exists with same mail";
        }

        User user1= userAuthRepo.findByPhoneNo(newUser.getPhoneNo());

        if(user1!=null){
            return "user already exits with same usernanme";
        }
        try{
            newUser.setPassword(PasswordEncryptor.encrypt(newUser.getPassword()));
            userAuthRepo.save(newUser);
        }catch (Exception e){
            return "exception occured while encrypting password";
        }

        return "User successfully created please login";

        
    }

    public String userSignIn(String email, String password) {
        User user= userAuthRepo.findByEmail(email);
        if(user==null){
            return "user not found with the email";
        }
        try {
            if(!(user.getPassword().equals(PasswordEncryptor.encrypt(password)))){
                return "Wrong password enterd";
            }else {
                var authToken= new TokenUser(null, UUID.randomUUID().toString(),user);
                tokenRepo.save(authToken);
                return "login success here is the authentication token: "+authToken.getToken();
            }
        }catch (Exception e){
            return "exception occurd while password check";
        }

    }

    public String userSignOut(String email, String token) {
        User user= userAuthRepo.findByEmail(email);
        TokenUser tokenUser=tokenRepo.findByToken(token);
        if(user==null){
            return "unauthorized access";
        }else if(tokenUser.getToken().equals(token) && user.getId().equals(tokenUser.getUser().getId())){
             tokenRepo.deleteByToken(token);
             return "logOut success";
        }
        return "Unauthorized acess";
    }
}
