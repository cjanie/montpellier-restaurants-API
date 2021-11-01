package com.spring.restaurants;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.restaurants.usecases.Restaurant;

public class OpenDataDeserializer {

    private ObjectMapper objectMapper;

    public OpenDataDeserializer() {
        this.objectMapper = new ObjectMapper();
    }

    public Set<Restaurant> deserializeRestaurants(String data/*Set<JsonNode> featuresProperties*/) throws JsonMappingException, JsonProcessingException {
        Set<JsonNode> features = this.formatFeaturesAsSetOfNodes(this.extractFeatures(data));
        Set<JsonNode> featuresProperties = this.extractFeaturesProperties(features);
        Set<Restaurant> restaurants = new HashSet<>();
        featuresProperties.forEach(featureProperties -> {
            Restaurant restaurant = new Restaurant(featureProperties.get("name").asText());
            restaurant.setId(Long.parseLong(featureProperties.get("osm_id").asText()));
            restaurant.setHouseNumber(featureProperties.get("addr_housenumber").asText());
            restaurant.setStreet(featureProperties.get("addr_street").asText());
            restaurants.add(restaurant);
        });
        return restaurants;
    }

    // Structure json
    // https://data.montpellier3m.fr/sites/default/files/ressources/OSM_Metropole_restauration_bar.json

    private JsonNode extractFeatures(String data) throws JsonMappingException, JsonProcessingException {
        JsonNode features = objectMapper.readTree(data).get("features");
        return features;
    }

    private Set<JsonNode> formatFeaturesAsSetOfNodes(JsonNode features) {
        Set<JsonNode> jsonNodes = new HashSet<>();
        if(!features.isEmpty()) {
            features.forEach(feature -> {
                jsonNodes.add(feature);
            });
        }
        return jsonNodes;
    }

    private Set<JsonNode> extractFeaturesProperties(Set<JsonNode> features) {
        Set<JsonNode> jsonNodes = new HashSet<>();
        features.forEach(feature -> {
            JsonNode properties = feature.get("properties");
            jsonNodes.add(properties);
        });
        return jsonNodes;
    }
    
    
}
