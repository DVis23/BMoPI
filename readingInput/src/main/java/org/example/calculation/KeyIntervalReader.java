package org.example.calculation;

import org.example.KeyInterval;

import java.util.ArrayList;
import java.util.List;

public class KeyIntervalReader {

    public static List<KeyInterval> readKeyInterval(List<long[]> events) {
        List<KeyInterval> keyIntervals = new ArrayList<>();
        for (int i = 0; i < events.size() - 1; i++) {
            keyIntervals.add(new  KeyInterval(Math.abs(events.get(i + 1)[1] - events.get(i)[1])));
        }
        return keyIntervals;
    }
}
