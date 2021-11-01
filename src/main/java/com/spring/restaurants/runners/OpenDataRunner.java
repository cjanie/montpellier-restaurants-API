package com.spring.restaurants.runners;

import java.util.Set;

import com.spring.restaurants.OpenDataDeserializer;
import com.spring.restaurants.feignclient.OpenDataFeignClient;
import com.spring.restaurants.repositories.RestaurantsRepository;
import com.spring.restaurants.usecases.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OpenDataRunner implements CommandLineRunner {
    
    @Autowired
    OpenDataFeignClient feignClient;

    @Override
    public void run(String... args) throws Exception {
        String data = this.feignClient.getData();
        RestaurantsRepository.getInstance().setData(data);
    }


}
