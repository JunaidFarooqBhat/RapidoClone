package com.example.rapi.Service.AuthService;

import com.example.rapi.Model.Driver;
import com.example.rapi.Model.TokenDriver;
import com.example.rapi.Repo.VehicleRepo;
import com.example.rapi.Repo.DTokenRepo;
import com.example.rapi.Repo.DriverAuthRepo;
import com.example.rapi.Service.PassEnc.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DriverAuthService {

    @Autowired
   private DriverAuthRepo driverAuthRepo;

    @Autowired
    private DTokenRepo dTokenRepo;

    @Autowired
    private VehicleRepo bikeRepo;


    public String driverSignUp(Driver driver) {
        Driver driver1= driverAuthRepo.findByEmail(driver.getEmail());
        Driver driver2= driverAuthRepo.findByPhoneNo(driver.getPhoneNo());
        if(driver2!=null){
            return "Phn no. already in use";
        }
        if(driver1!=null){
            return "Driver with same mail exists";
        }else {
            var vehicle= driver.getVehicle();
            bikeRepo.save(vehicle);
            try{
                driver1.setPassword(PasswordEncryptor.encrypt(driver1.getPassword()));
                driverAuthRepo.save(driver1);
                return "Driver created successfully";
            }catch (Exception e){
                return "exception occured while password encryption";
            }
        }
    }

    public String driverSignIn(String email, String password) {
        Driver driver1= driverAuthRepo.findByEmail(email);
        if(driver1==null){
            return "Driver not found with the mail";
        }else {
            try {
                if(!(driver1.getPassword().equals(PasswordEncryptor.encrypt(password)))){
                    return "wrong password";
                }else{
                    var authToken= new TokenDriver(null, UUID.randomUUID().toString(),driver1);
                    dTokenRepo.save(authToken);
                    return "signIN success here is authentication token: "+authToken.getToken();
                }
            }catch (Exception e){
                return "exception occured in driver password matching";
            }
        }
    }

    public String driverSignOut(String email, String tokenValue) {
        Driver driver1= driverAuthRepo.findByEmail(email);
        TokenDriver tokenDriver= dTokenRepo.findByToken(tokenValue);
        if(driver1==null){
            return "unauthorized access";
        } else if (tokenDriver.getToken().equals(tokenValue) && tokenDriver.getDriver().getId().equals(driver1.getId())) {
            dTokenRepo.deleteByToken(tokenValue);
            return "logout success";
        }
        return "unauthorized access";
    }
}
