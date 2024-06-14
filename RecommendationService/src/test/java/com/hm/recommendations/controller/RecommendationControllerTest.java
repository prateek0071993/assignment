package com.hm.recommendations.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.recommendations.model.EventType;
import com.hm.recommendations.model.Outfit;
import com.hm.recommendations.model.RecommendationRequest;
import com.hm.recommendations.model.UserPreferences;
import com.hm.recommendations.service.RecommendationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecommendationController.class)
class RecommendationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RecommendationService recommendationService;

    @Autowired
    ObjectMapper objectMapper;

    RecommendationRequest recommendationRequest;
    List<Outfit> outfitList;

    @BeforeEach
    public void setup() {
        recommendationRequest = new RecommendationRequest();
        recommendationRequest.setEventType(EventType.CHRISTMAS);
        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setBudget(100);
        userPreferences.setStylePreferences(Arrays.asList("Formal", "Casual"));
        recommendationRequest.setUserPreferences(userPreferences);
        outfitList = new ArrayList<>();
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Jacket", "Red Christmas Jacket", 150.0, "Casual", 4));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Shirt", "Green Christmas Shirt", 50.0, "Casual", 7));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Trousers", "Black Trousers", 100.0, "Formal", 5));
    }

    @Test
    void testGetRecommendations() throws Exception {
        recommendationRequest = new RecommendationRequest();
        recommendationRequest.setEventType(EventType.CHRISTMAS);
        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setBudget(100);
        userPreferences.setStylePreferences(Arrays.asList("Formal", "Casual"));
        recommendationRequest.setUserPreferences(userPreferences);
        when(recommendationService.getRecommendations(recommendationRequest.getEventType(),
                recommendationRequest.getUserPreferences())).thenReturn(outfitList);

        mockMvc.perform(post("/api/recommendations")
                        .content(objectMapper.writeValueAsString(recommendationRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testGetRecommendations_InvalidRequest() throws Exception {
        RecommendationRequest invalidRequest = new RecommendationRequest();
        invalidRequest.setEventType(EventType.CHRISTMAS);

        mockMvc.perform(post("/api/recommendations")
                        .content(objectMapper.writeValueAsString(invalidRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").value("User preferences must not be null"));
    }
}
