package com.hm.recommendations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Outfit {

    private EventType eventType;
    private String outfitType;
    private String outfitName;
    private double outfitPrice;
    private String outfitStyle;
    private int outfitQuantity;
}
