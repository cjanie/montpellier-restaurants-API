package com.spring.restaurants.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "OpenData", url = "https://data.montpellier3m.fr/sites/default/files/ressources")
public interface OpenDataFeignClient {

    @GetMapping("/OSM_Metropole_restauration_bar.json")
    String getData();

}
