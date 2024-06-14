package com.hm.recommendations.service;

import com.hm.recommendations.exception.model.ExceptionConstants;
import com.hm.recommendations.exception.model.OutfitNotFoundException;
import com.hm.recommendations.model.EventType;
import com.hm.recommendations.model.Outfit;
import com.hm.recommendations.model.UserPreferences;
import com.hm.recommendations.util.OutfitInventory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecommendationService {

    public List<Outfit> getRecommendations(EventType eventType, UserPreferences userPreferences) {
        log.info("Getting recommendations for event type: {} and user preferences: {}", eventType, userPreferences);

        List<Outfit> filteredOutfits = filterOutfits(eventType, userPreferences.getBudget(), userPreferences.getStylePreferences());

        if (filteredOutfits.isEmpty()) {
            log.warn("No outfits matched for event type: {} with budget: {} and styles: {}", eventType, userPreferences.getBudget(),
                    userPreferences.getStylePreferences());
            throw new OutfitNotFoundException(ExceptionConstants.OUTFIT_NOT_MATCHED_EXCEPTION);
        }
        log.info("Found {} outfits for event type: {} and user preferences: {}", filteredOutfits.size(), eventType, userPreferences);
        return filteredOutfits;
    }

    public List<Outfit> filterOutfits(EventType eventType, double maxBudget, List<String> styles) {
        log.debug("Filtering outfits for event type: {}, max budget: {}, styles: {}", eventType, maxBudget, styles);

        List<Outfit> outfitList = OutfitInventory.OUTFIT_INVENTORY;

        return outfitList.stream()
                .filter(outfit -> outfit.getEventType() == eventType)
                .filter(outfit -> outfit.getOutfitPrice() <= maxBudget)
                .filter(outfit -> styles.contains(outfit.getOutfitStyle()))
                .filter(outfit -> outfit.getOutfitQuantity() > 0)
                .collect(Collectors.toList());
    }
}
