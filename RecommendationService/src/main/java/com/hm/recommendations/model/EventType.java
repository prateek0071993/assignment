package com.hm.recommendations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventType {
    CHRISTMAS("Christmas"),
    WEDDING("Wedding");

    private final String eventName;
}