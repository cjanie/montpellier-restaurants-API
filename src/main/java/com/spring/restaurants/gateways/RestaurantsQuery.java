package com.spring.restaurants.gateways;

import java.io.IOException;
import java.util.Set;

import com.spring.restaurants.usecases.Restaurant;

public interface RestaurantsQuery {
    Set<Restaurant> findAll() throws IOException;
}
