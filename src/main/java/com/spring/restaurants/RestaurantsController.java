package com.spring.restaurants;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.spring.restaurants.gateways.RestaurantsQuery;
import com.spring.restaurants.repositories.RestaurantsRepository;
import com.spring.restaurants.usecases.Restaurant;
import com.spring.restaurants.usecases.RetrieveRestaurants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantsController {
    
    private RestaurantsQuery restaurantsQuery;


    public RestaurantsController() {
        this.restaurantsQuery = RestaurantsRepository.getInstance();
    }


    @GetMapping("restaurants")
    public ResponseEntity<?> listRestaurants() {
        try {
            return new ResponseEntity<>(new RetrieveRestaurants(this.restaurantsQuery).handle(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
