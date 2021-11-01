package com.spring.restaurants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.junit.jupiter.api.Test;

public class OpenDataDeserializerTests {
    
    
    @Test
    public void shouldReturnRestaurantsWhenFeaturesHasElements() throws JsonMappingException, JsonProcessingException {
        String datas = "{ \"type\": \"FeatureCollection\", \"features\": [{\"properties\": {\"name\": \"Jojo\"}}, {\"properties\": {\"name\": \"Lala\"}}] }";
        assert(new OpenDataDeserializer().deserializeRestaurants(datas).size() == 2);
    }
}
