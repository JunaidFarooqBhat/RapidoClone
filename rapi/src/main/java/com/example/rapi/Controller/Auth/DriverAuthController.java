package com.example.rapi.Controller.Auth;

import com.example.rapi.Model.Driver;
import com.example.rapi.Service.AuthService.DriverAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class DriverAuthController {
    @Autowired
    private DriverAuthService driverAuthService;

    //signUp
    @PostMapping("driver/signup")
    public String driverSignUp(@RequestBody Driver driver)
    {
        return driverAuthService.driverSignUp(driver);
    }



    //sign in
    @PostMapping("driver/signIn/{email}/{password}")
    public String userSignIn(@PathVariable String email, @PathVariable String password)
    {
        return driverAuthService.driverSignIn(email,password);
    }


    //sign out
    @DeleteMapping("driver/signOut")
    public String userSignOut(@RequestParam String email, @RequestParam String tokenValue)
    {
        return driverAuthService.driverSignOut(email,tokenValue);
    }
}
