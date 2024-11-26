package org.example;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.ArrayList;
import java.util.List;

public class KeyListener implements NativeKeyListener {
    private final List<long[]> currentKeyEvents = new ArrayList<>();
    private final List<long[]> keyEvents = new ArrayList<>();
    private boolean stopListening = false;
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_ENTER) {
            stopListening = true;
        } else {
            long[] event = new long[2];
            event[0] = e.getKeyCode();
            event[1] = System.currentTimeMillis();
            currentKeyEvents.add(event);
        }
    }
    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        long releasedTime = System.currentTimeMillis();
        for (long[] currentEvent : currentKeyEvents) {
            if (currentEvent[0] == e.getKeyCode()) {
                long[] event = new long[3];
                event[0] = currentEvent[0];
                event[1] = currentEvent[1];
                event[2] = releasedTime;
                keyEvents.add(event);
                currentKeyEvents.remove(currentEvent);
                break;
            }
        }
    }
    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }
    public List<long[]> getKeyEvents() {
        return new ArrayList<long[]>(keyEvents) {};
    }
    public boolean isListening() {
        return !stopListening;
    }
}
