package com.spring.restaurants.usecases;

import java.io.IOException;
import java.util.Set;

import com.spring.restaurants.gateways.RestaurantsQuery;

public class RetrieveRestaurants {

    private RestaurantsQuery restaurantsQuery;


    public RetrieveRestaurants(RestaurantsQuery restaurantsQuery) {
        this.restaurantsQuery = restaurantsQuery;
    }
    
    public Set<Restaurant> handle() throws IOException {
        return this.restaurantsQuery.findAll();
    }
}
