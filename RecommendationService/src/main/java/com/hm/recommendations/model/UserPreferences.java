package com.hm.recommendations.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserPreferences {

    @Min(value = 1, message = "Budget must be greater than zero.")
    private double budget;

    @NotEmpty(message = "At least one style preference is required.")
    private List<String> stylePreferences;
}
