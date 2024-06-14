package com.hm.recommendations.service;

import com.hm.recommendations.exception.model.ExceptionConstants;
import com.hm.recommendations.exception.model.OutfitNotFoundException;
import com.hm.recommendations.model.EventType;
import com.hm.recommendations.model.Outfit;
import com.hm.recommendations.model.UserPreferences;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;

class RecommendationServiceTest {

    @InjectMocks
    private RecommendationService recommendationService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void testGetRecommendations_OutfitsFound() {
        EventType eventType = EventType.CHRISTMAS;
        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setBudget(130.0);
        userPreferences.setStylePreferences(List.of("Formal"));

        List<Outfit> outfitList = new ArrayList<>();
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Trousers", "Black Trousers", 100.0, "Formal", 5));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Coat", "Winter Coat", 120.0, "Formal",4));

        List<Outfit> recommendations = recommendationService.getRecommendations(eventType, userPreferences);

        assertNotNull(recommendations);
        assertFalse(recommendations.isEmpty());
        assertEquals(outfitList.size(), recommendations.size());
    }

    @Test
    void testGetRecommendations_NoOutfitsFound() {
        EventType eventType = EventType.CHRISTMAS;
        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setBudget(10);
        userPreferences.setStylePreferences(List.of("Formal"));

        Exception exception = Assertions.assertThrows(OutfitNotFoundException.class, () -> recommendationService.getRecommendations(eventType, userPreferences));

        assertNotNull(exception);
        assertEquals(ExceptionConstants.OUTFIT_NOT_MATCHED_EXCEPTION, exception.getMessage());
    }
}
