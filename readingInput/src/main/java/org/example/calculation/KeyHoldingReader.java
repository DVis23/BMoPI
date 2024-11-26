package org.example.calculation;

import org.example.KeyHoldingTime;

import java.util.ArrayList;
import java.util.List;

public class KeyHoldingReader {

    public static List<KeyHoldingTime> readKeyHolding(List<long[]> events) {
        List<KeyHoldingTime> keyHoldingTimes = new ArrayList<>();
        for (long[] event : events) {
            keyHoldingTimes.add(new KeyHoldingTime(event[2] - event[1]));
        }
        return keyHoldingTimes;
    }
}
