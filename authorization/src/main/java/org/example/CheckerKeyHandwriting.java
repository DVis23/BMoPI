package org.example;

import org.example.calculation.KeyHoldingReader;
import org.example.calculation.KeyIntervalReader;

import java.util.List;

public class CheckerKeyHandwriting {
    private static final double LIMIT = 0.5;
    public static boolean checkKeyHandwriting(List<long[]> keyEvents, BiometricMatrix biometricMatrix) {
        List<KeyHoldingTime> keyHolding1 = KeyHoldingReader.readKeyHolding(keyEvents);
        List<KeyInterval> keyInterval1 = KeyIntervalReader.readKeyInterval(keyEvents);

        List<KeyHoldingTime> keyHolding2 = biometricMatrix.getKeyHoldingTimes();
        List<KeyInterval> keyInterval2 = biometricMatrix.getKeyIntervals();

        for (int i = 0; i < keyHolding1.size(); i++) {
            if (Math.abs(keyHolding1.get(i).getTime() - keyHolding2.get(i).getTime()) > keyHolding2.get(i).getTime()*LIMIT) {
                return false;
            }
        }
        for (int i = 0; i < keyInterval1.size(); i++) {
            if (Math.abs(keyInterval1.get(i).getTime() - keyInterval2.get(i).getTime()) > keyInterval2.get(i).getTime()*LIMIT) {
                return false;
            }
        }
       return true;
    }
}
