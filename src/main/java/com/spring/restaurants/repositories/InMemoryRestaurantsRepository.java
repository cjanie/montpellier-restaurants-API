package com.spring.restaurants.repositories;

import java.util.Set;

import com.spring.restaurants.gateways.RestaurantsQuery;
import com.spring.restaurants.usecases.Restaurant;

public class InMemoryRestaurantsRepository implements RestaurantsQuery {

    Set<Restaurant> restaurants;

    @Override
    public Set<Restaurant> findAll() {
        
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    
}
