package org.example;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import java.util.List;

public class KeyPressLogger {
    public static List<long[]> keyLogging() throws NativeHookException {
        try {
            LogManager.getLogManager().reset();
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        KeyListener keyListener = new KeyListener();
        GlobalScreen.addNativeKeyListener(keyListener);
        while (keyListener.isListening()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        GlobalScreen.removeNativeKeyListener(keyListener);
        List<long[]> keyEvents = keyListener.getKeyEvents();
        Collections.sort(keyEvents, Comparator.comparingLong(arr -> arr[1]));
        GlobalScreen.unregisterNativeHook();
        return keyEvents;
    }
}
