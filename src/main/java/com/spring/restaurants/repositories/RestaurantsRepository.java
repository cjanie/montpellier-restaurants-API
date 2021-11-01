package com.spring.restaurants.repositories;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spring.restaurants.OpenDataDeserializer;
import com.spring.restaurants.gateways.RestaurantsQuery;
import com.spring.restaurants.usecases.Restaurant;

public class RestaurantsRepository implements RestaurantsQuery {

    private String data;

    private static RestaurantsRepository INSTANCE;

    private RestaurantsRepository() {
        this.data = "{ \"type\": \"FeatureCollection\", \"features\": [{\"properties\": {\"name\": \"Jojo\"}}, {\"properties\": {\"name\": \"Lala\"}}] }";
    }

    public static RestaurantsRepository getInstance() {
        if(RestaurantsRepository.INSTANCE == null)
            RestaurantsRepository.INSTANCE = new RestaurantsRepository();
        return RestaurantsRepository.INSTANCE;
    }
    
    @Override
    public Set<Restaurant> findAll() throws IOException {
        Set<Restaurant> restaurants = new HashSet<>();
		try {
            restaurants = new OpenDataDeserializer().deserializeRestaurants(data);
            
        } catch (JsonMappingException e) {
            e.printStackTrace();
            throw e;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw e;
        }
        return restaurants;
    }
    
    public void setData(String data) {
        this.data = data;
    }
}
