package com.example.rapi.Service;

import com.example.rapi.Controller.Location.RateList;
import com.example.rapi.Dto.FromToDto;
import com.example.rapi.Model.User;
import org.springframework.stereotype.Service;

@Service
public class FareService {

    public RateList checkFare(FromToDto fromToLocation) {
       String userEmail=fromToLocation.getUserEmail();
       String token =fromToLocation.getToken();
        Double fromlat=fromToLocation.getFrom().getLat();
        Double fromlng=fromToLocation.getFrom().getLng();
        Double tolat=fromToLocation.getTo().getLat();
        Double tolng=fromToLocation.getTo().getLng();
        Double Distance = calculateDistance(fromlat,fromlng,tolat,tolng);
        RateList Ratelist= calculateRate(Distance);
        return Ratelist;
    }

    private RateList calculateRate(Double distance) {
        Double bikefare = 15 * distance;
        Double cabfare = 20 * distance;
        Double autofare = 17 * distance;

        if(distance>1.00) {
            bikefare = 3 * distance-1.00;
            cabfare = 7 * distance-1.00;
            autofare = 5 * distance-1.00;
        }
        String focab=String.format("%.2f", cabfare);
        String fobike=String.format("%.2f", bikefare);
        String forauto=String.format("%.2f", autofare);
        return new RateList(Double.parseDouble(fobike),Double.parseDouble(focab),Double.parseDouble(forauto));
    }

    private Double calculateDistance(Double lat1, Double lon1, Double lat2, Double  lon2) {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }
}
