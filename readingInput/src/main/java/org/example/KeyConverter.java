package org.example;

import org.jnativehook.keyboard.NativeKeyEvent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class KeyConverter {

    private static char convertKeyCodeToChar(int keyCode, boolean shift, boolean capsLock) {
        char character = KeyEvent.CHAR_UNDEFINED;
        switch (keyCode) {
            case NativeKeyEvent.VC_A:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'A' : 'a';
                break;
            case NativeKeyEvent.VC_B:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'B' : 'b';
                break;
            case NativeKeyEvent.VC_C:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'C' : 'c';
                break;
            case NativeKeyEvent.VC_D:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'D' : 'd';
                break;
            case NativeKeyEvent.VC_E:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'E' : 'e';
                break;
            case NativeKeyEvent.VC_F:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'F' : 'f';
                break;
            case NativeKeyEvent.VC_G:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'G' : 'g';
                break;
            case NativeKeyEvent.VC_H:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'H' : 'h';
                break;
            case NativeKeyEvent.VC_I:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'I' : 'i';
                break;
            case NativeKeyEvent.VC_J:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'J' : 'j';
                break;
            case NativeKeyEvent.VC_K:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'K' : 'k';
                break;
            case NativeKeyEvent.VC_L:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'L' : 'l';
                break;
            case NativeKeyEvent.VC_M:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'M' : 'm';
                break;
            case NativeKeyEvent.VC_N:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'N' : 'n';
                break;
            case NativeKeyEvent.VC_O:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'O' : 'o';
                break;
            case NativeKeyEvent.VC_P:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'P' : 'p';
                break;
            case NativeKeyEvent.VC_Q:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'Q' : 'q';
                break;
            case NativeKeyEvent.VC_R:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'R' : 'r';
                break;
            case NativeKeyEvent.VC_S:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'S' : 's';
                break;
            case NativeKeyEvent.VC_T:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'T' : 't';
                break;
            case NativeKeyEvent.VC_U:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'U' : 'u';
                break;
            case NativeKeyEvent.VC_V:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'V' : 'v';
                break;
            case NativeKeyEvent.VC_W:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'W' : 'w';
                break;
            case NativeKeyEvent.VC_X:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'X' : 'x';
                break;
            case NativeKeyEvent.VC_Y:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'Y' : 'y';
                break;
            case NativeKeyEvent.VC_Z:
                character = ((shift && !capsLock) || (!shift && capsLock)) ? 'Z' : 'z';
                break;
            case NativeKeyEvent.VC_1:
                character = shift ? '!' : '1';
                break;
            case NativeKeyEvent.VC_2:
                character = shift ? '@' : '2';
                break;
            case NativeKeyEvent.VC_3:
                character = shift ? '#' : '3';
                break;
            case NativeKeyEvent.VC_4:
                character = shift ? '$' : '4';
                break;
            case NativeKeyEvent.VC_5:
                character = shift ? '%' : '5';
                break;
            case NativeKeyEvent.VC_6:
                character = shift ? '^' : '6';
                break;
            case NativeKeyEvent.VC_7:
                character = shift ? '&' : '7';
                break;
            case NativeKeyEvent.VC_8:
                character = shift ? '*' : '8';
                break;
            case NativeKeyEvent.VC_9:
                character = shift ? '(' : '9';
                break;
            case NativeKeyEvent.VC_0:
                character = shift ? ')' : '0';
                break;
            case NativeKeyEvent.VC_PERIOD:
                character = shift ? '>' : '.';
                break;
            case NativeKeyEvent.VC_COMMA:
                character = shift ? '<' : ',';
                break;
            case NativeKeyEvent.VC_MINUS:
                character = shift ? '_' : '-';
                break;
            case NativeKeyEvent.VC_EQUALS:
                character = shift ? '+' : '=';
                break;
            case NativeKeyEvent.VC_SPACE:
                character = ' ';
                break;
            default:
                character = '?';
                break;
        }
        return character;
    }


    public static String convertKeyCodesToString(List<long []> keyEvents) {

        List<Integer> keyCodes = new ArrayList<>();
        for (long[] event : keyEvents) {
            keyCodes.add((int) event[0]);
        }

        boolean shift = false;
        boolean capsLock = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < keyCodes.size(); i++) {
            Integer keyCode = keyCodes.get(i);
            if (keyCode == NativeKeyEvent.VC_DELETE) {
                if (i != 0) stringBuilder.setLength(stringBuilder.length() - 1);
            } else if ((keyCode == NativeKeyEvent.VC_SHIFT_L) || (keyCode == NativeKeyEvent.VC_SHIFT_R)) {
                shift = !shift;
            } else if (keyCode == NativeKeyEvent.VC_CAPS_LOCK) {
                capsLock = !capsLock;
            } else {
                stringBuilder.append(convertKeyCodeToChar(keyCode, shift, capsLock));
                if (shift) {
                    shift = !shift;
                }
            }

        }
        return stringBuilder.toString();
    }
}
