package org.example.calculation;

import java.util.List;

public class OverlayChecker {
    public static int checkOfOverlay(List<long[]> events) {
        int count = 0;
        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                if (events.get(i)[1] < events.get(j)[1]
                        && events.get(i)[2] < events.get(j)[2]
                        && events.get(i)[2] > events.get(j)[1]) count++;
            }
        }
        return count;
    }
}
