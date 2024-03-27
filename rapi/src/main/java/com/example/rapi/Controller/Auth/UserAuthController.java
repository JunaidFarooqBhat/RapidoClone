package com.example.rapi.Controller.Auth;

import com.example.rapi.Model.User;
import com.example.rapi.Service.AuthService.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAuthController {
    @Autowired
    private UserAuthService userAuthService;

    //signUp
    @PostMapping("user/signup")
    public String userSignUp(@RequestBody User newUser)
    {
        return userAuthService.userSignUp(newUser);
    }



    //sign in
    @PostMapping("user/signIn/{email}/{password}")
    public String userSignIn(@PathVariable String email, @PathVariable String password)
    {
        return userAuthService.userSignIn(email,password);
    }


    //sign out
    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestParam String email, @RequestParam String tokenValue)
    {
        return userAuthService.userSignOut(email,tokenValue);
    }

}
