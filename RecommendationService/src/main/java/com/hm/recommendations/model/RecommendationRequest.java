package com.hm.recommendations.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RecommendationRequest {

    @NotNull(message = "Event type must not be null")
    private EventType eventType;

    @NotNull(message = "User preferences must not be null")
    @Valid
    private UserPreferences userPreferences;
}
