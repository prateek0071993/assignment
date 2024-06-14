package com.hm.recommendations.controller;

import com.hm.recommendations.model.Outfit;
import com.hm.recommendations.model.RecommendationRequest;
import com.hm.recommendations.service.RecommendationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;

    /**
     * Handles POST requests to generate outfit recommendations based on the provided event type and user preferences.
     *
     * @param recommendationRequest the recommendation request containing event type and user preferences
     * @return a ResponseEntity containing the list of recommended outfits and HTTP status
     */

    @PostMapping("/recommendations")
    public ResponseEntity<?> getRecommendations(@Valid @RequestBody RecommendationRequest recommendationRequest) {
        log.info("Received recommendation request for event type: {} with user preferences: {}",
                recommendationRequest.getEventType(),
                recommendationRequest.getUserPreferences());

        List<Outfit> recommendations = recommendationService.getRecommendations(recommendationRequest.getEventType(),
                recommendationRequest.getUserPreferences());
        log.info("Returning {} recommendations", recommendations.size());

        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }
}