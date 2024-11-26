package org.example;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;
import java.util.ArrayList;

public class BiometricMatrix {
    private final List<KeyHoldingTime> keyHoldingTimes = new ArrayList<>();
    private final List<KeyInterval> keyIntervals = new ArrayList<>();

    @JsonCreator
    public BiometricMatrix(@JsonProperty("keyHoldingTimes") List<KeyHoldingTime> keyHoldingTimes,
                           @JsonProperty("keyIntervals") List<KeyInterval> keyIntervals) {
        this.keyHoldingTimes.addAll(keyHoldingTimes);
        this.keyIntervals.addAll(keyIntervals);

    }
    public List<KeyHoldingTime> getKeyHoldingTimes() {
        return new ArrayList<KeyHoldingTime>(keyHoldingTimes);
    }
    public List<KeyInterval> getKeyIntervals() {
        return new ArrayList<KeyInterval>(keyIntervals);
    }
    public void addKeyHoldingTime(KeyHoldingTime keyHoldingTime) {
        keyHoldingTimes.add(keyHoldingTime);
    }
    public void addKeyHoldingTimes(List<KeyHoldingTime> keyHoldingTimes) {
        keyHoldingTimes.addAll(keyHoldingTimes);
    }
    public void addKeyKeyInterval(KeyInterval keyInterval) {
        keyIntervals.add(keyInterval);
    }
    public void addKeyKeyIntervals(List<KeyHoldingTime> keyIntervals) {
        keyIntervals.addAll(keyIntervals);
    }
}
