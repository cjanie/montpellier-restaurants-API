package com.spring.restaurants;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.spring.restaurants.repositories.InMemoryRestaurantsRepository;
import com.spring.restaurants.usecases.Restaurant;
import com.spring.restaurants.usecases.RetrieveRestaurants;

import org.junit.jupiter.api.Test;

public class RetrieveRestaurantsTests {



    @Test
    public void shouldReturn1RestaurantWhenThereIs1() throws IOException {
        InMemoryRestaurantsRepository repository = new InMemoryRestaurantsRepository();
        Set<Restaurant> restaurants = new HashSet<>();
        restaurants.add(new Restaurant("joj"));
        repository.setRestaurants(restaurants);
        assertThat(new RetrieveRestaurants(repository).handle().size() == 1);
    }

    @Test
    public void shouldReturn2RestaurantsWhenThereAre2() throws IOException {
        InMemoryRestaurantsRepository repository = new InMemoryRestaurantsRepository();
        Set<Restaurant> restaurants = new HashSet<>();
        restaurants.add(new Restaurant("joj"));
        restaurants.add(new Restaurant("joie"));
        repository.setRestaurants(restaurants);
        assertThat(new RetrieveRestaurants(repository).handle().size() == 2);
    }
}
